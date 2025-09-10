package com.ranjan.viddown.dashedmuxer

import java.io.File
import java.io.RandomAccessFile
import java.nio.ByteBuffer

class DashedWriter(file: File, val sources: List<DashedParser>, val progress: (percent: String) -> Unit = { _-> }){


    val output= RandomAccessFile(file,"rw")
    val mp4Utils= utils()

    fun buildNonFMp4(){
        val ftyp = mp4Utils.writeFtyp()

        // Begin writing to file
        output.seek(0)
        output.write(ftyp)

        //reserve space or write flase data for moov box and its header size and type

        /*val moovStart = output.filePointer
        putInt(totalSize)
        put("moov".toByteArray())*/

        val ts = sources.sumOf { it.totalSamplesFromMoof }
        val estimatedMoovSize= estimateMoovSize(ts)
        val moovReserveSize = estimatedMoovSize
        val moovPosition = output.filePointer
        output.write(ByteArray(moovReserveSize))




        writeMdat()

        val trakList = mutableListOf<ByteArray>()

        //writting moov atom
        for (source in sources){
            val stsc = mp4Utils.writeStsc(source.samplesPerChunkList)
            val stsz = mp4Utils.writeStsz(source.samplesSizes)
            val stco = mp4Utils.writeStco(source.chunksOffsets)

            val drefBox = ByteBuffer.allocate(28).apply {
                putInt(28); put("dref".toByteArray())
                putInt(0); putInt(1) // version/flags and entry count
                putInt(12); put("url ".toByteArray()); putInt(1) // version/flags = self-contained
            }.array()

            val dinfBox = ByteBuffer.allocate(36).apply {
                putInt(36); put("dinf".toByteArray())
                put(drefBox)
            }.array()

            val hdlr=mp4Utils.writeHdlr(source.handlerType)


           if (source.handlerType=="soun"){
               val stts = mp4Utils.writeStts(source.samplesSizes.size, 1024)
               val stbl = mp4Utils.writeStbl(source.stsdBox!!, stts, stsc, stsz, stco)
               val vmhd=mp4Utils.writeVmhd("smhd")

               val minfBox=mp4Utils.writeMinf(
                   vmhdOrSmhd = vmhd,
                   dinfBox = dinfBox,
                   stblBox = stbl
               )
               val  mdhd=mp4Utils.writeMdhd(
                   timeScale = source.mediaTimescale,
                   duration = source.mediaDuration.toInt()
               )
               val media=mp4Utils.writeMdia(
                   mdhd = mdhd,
                   hdlr = hdlr,
                   minf = minfBox
               )
               val tkhd=mp4Utils.writeTkhd(
                   duration = source.trackDuration.toInt()
               )

               val track=mp4Utils.writeTrak(
                   tkhd = tkhd,
                   mdia = media
               )
               trakList.add(track)

           }else{
               val stts = mp4Utils.writeStts(source.samplesSizes.size, 512)
               val stss = mp4Utils.writeStss(source.keySamplesIndices)
               val ctts = mp4Utils.writeCtts(source.cttsEntries)
               val stbl = mp4Utils.writeStbl(source.stsdBox!!, stts, stsc, stsz, stco, stss, ctts)

               val vmhd=mp4Utils.writeVmhd("vmhd")

               val minfBox=mp4Utils.writeMinf(
                   vmhdOrSmhd = vmhd,
                   dinfBox = dinfBox,
                   stblBox = stbl
               )
               val  mdhd=mp4Utils.writeMdhd(
                   timeScale = source.mediaTimescale,
                   duration = source.mediaDuration.toInt()
               )
               val media=mp4Utils.writeMdia(
                   mdhd = mdhd,
                   hdlr = hdlr,
                   minf = minfBox
               )
               val tkhd=mp4Utils.writeTkhd(
                   duration = source.trackDuration.toInt()
               )

               val track=mp4Utils.writeTrak(
                   tkhd = tkhd,
                   mdia = media
               )
               trakList.add(track)
           }
        }


        val movieTimeScale = 1000
        val maxTrack = sources.maxBy { it.trackDuration.toDouble() / it.mediaTimescale }

        val mvhdDuration = (maxTrack.trackDuration * movieTimeScale) / maxTrack.mediaTimescale

        val mvhd = mp4Utils.writeMvhd(
            timeScale = movieTimeScale,
            duration = mvhdDuration.toInt(),
            nextTrack = sources.size + 1
        )


        val moovBox=mp4Utils.writeMoov(mvhd,trakList)


        output.seek(moovPosition)
        output.write(moovBox)
        output.close()
        progress("Finished")

    }

    fun writeMdat() {
        val mdatStart = output.filePointer

        // Write placeholder for size + "mdat"
        output.writeInt(0)
        output.write("mdat".toByteArray())

        val ts = sources.sumOf { it.totalSamplesFromMoof }



        while (true) {
            val sourcesDone = mutableListOf<Int>()

            for (source in sources) {
                val samples = source.getSamples(source.initialChunk)
                source.initialChunk = false

                if (samples.isNotEmpty()) {
                    source.chunksOffsets.add(output.filePointer)
                    source.samplesPerChunkList.add(samples.size) // ✅ TRACK CHUNK SIZE

                    for (sample in samples) {
                        source.reader.seek(sample.offset)
                        val data = ByteArray(sample.size.toInt())
                        source.reader.readFully(data)
                        output.write(data)
                        source.samplesSizes.add(sample.size)

                        if (source.handlerType == "vide") {
                            if (sample.isSyncSample) {
                                source.keySamplesIndices.add(source.samplesSizes.lastIndex)
                            }

                            // CTTS run-length logic
                            val cto = sample.compositionTimeOffset
                            if (source.lastOffset == null) {
                                source.lastOffset = cto
                                source.runLength = 1
                            } else if (cto == source.lastOffset) {
                                source.runLength++
                            } else {
                                source.cttsEntries.add(source.runLength to source.lastOffset!!)
                                source.lastOffset = cto
                                source.runLength = 1
                            }
                        }
                        val samplesWritten = source.samplesSizes.size
                        val totalSamples = ts
                        val progressPercent: Int = ((samplesWritten.toDouble() / totalSamples.toDouble()) * 100).toInt()
                        progress("Merging - $progressPercent%")

                    }
                } else {
                    sourcesDone.add(1)

                    if (source.lastOffset != null && source.runLength > 0) {
                        source.cttsEntries.add(source.runLength to source.lastOffset!!)
                    }
                }

            }

            if (sourcesDone.size == sources.size) break
        }

        val mdatEnd = output.filePointer
        val sizeLong = mdatEnd - mdatStart
        require(sizeLong <= Int.MAX_VALUE) { "mdat too large: $sizeLong bytes" }

        val size = sizeLong.toInt()
        output.seek(mdatStart)
        output.writeInt(size)
        output.seek(mdatEnd)
        println("✅ Samples written. mdat size: $size bytes")
    }
}
