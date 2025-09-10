package com.ranjan.viddown.screens.utils

import android.content.Context
import android.content.Intent
import android.media.MediaScannerConnection
import android.os.Environment
import androidx.core.net.toUri
import com.ranjan.viddown.dashedmuxer.DashedParser
import com.ranjan.viddown.dashedmuxer.DashedWriter
import com.ranjan.viddown.screens.models.DownloadItem
import com.ranjan.viddown.screens.models.DownloadsViewModel
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import kotlin.math.roundToInt


fun addToDownloadsList(
    downloadList: DownloadsViewModel,
    title: String,
    videoFmt: JSONObject,
    audioFmt: JSONObject,
    thumbnail: String,
    context: Context
) {
    val currentTimeMillis = System.currentTimeMillis()
    val qualtiyLabel=if (videoFmt.has("qualityLabel")){videoFmt.getString("qualityLabel")}else{""}
    if (videoFmt==audioFmt){
        val movieFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        val audioFile = File("${movieFolder}/$title.mp3")

        val videoUrl = videoFmt.getString("url")
        val audioUrl = audioFmt.getString("url")

        val videoContentLength = videoFmt.getString("contentLength").toLong()
        val audioContentLength = audioFmt.getString("contentLength").toLong()

        val downloadItem = DownloadItem(
            fileName = title,
            thumbnailUrl = thumbnail,
            videoUrl = videoUrl,
            audioUrl = audioUrl,
            downloadStartTime = currentTimeMillis,
            onDiskInitial = audioFile.length(),
            onWebInitial = videoContentLength+audioContentLength,
            inRamInitial = 0
        )

        downloadList.addDownload(downloadItem)

        // Start combined download
        downloadFiles(downloadList, downloadItem, audioFile, audioFile, audioContentLength,videoContentLength, context = context)
    }else{
        val videoFile = File("${context.filesDir}/$title($qualtiyLabel).mp4")
        val audioFile = File("${context.filesDir}/$title.mp3")

        val videoUrl = videoFmt.getString("url")
        val audioUrl = audioFmt.getString("url")

        val videoContentLength = videoFmt.getString("contentLength").toLong()
        val audioContentLength = audioFmt.getString("contentLength").toLong()

        val downloadItem = DownloadItem(
            fileName = title,
            thumbnailUrl = thumbnail,
            videoUrl = videoUrl,
            audioUrl = audioUrl,
            downloadStartTime = currentTimeMillis,
            onDiskInitial = videoFile.length(),
            onWebInitial = videoContentLength+audioContentLength,
            inRamInitial = 0
        )

        downloadList.addDownload(downloadItem)

        // Start combined download
        downloadFiles(downloadList, downloadItem, videoFile, audioFile, audioContentLength,videoContentLength,context)
    }
}




fun downloadFiles(
    downloadsViewModel: DownloadsViewModel,
    downloadItem: DownloadItem,
    videoFile: File,
    audioFile: File,
    audioContentLength: Long,
    videoContentLength: Long,context: Context
) {

    fun updateProgress(inRam: Long,speedText: String){
        downloadsViewModel.updateProgress(downloadItem.fileName,inRam,speedText)
    }

    fun doMuxing(){
        val movieFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        val audioPraser= DashedParser(audioFile)
        val videoPraser= DashedParser(videoFile)
        audioPraser.parse()
        videoPraser.parse()
        val finalVideoFile=File("$movieFolder/${videoFile.name}")
        val writter= DashedWriter(
            finalVideoFile,
            listOf(videoPraser, audioPraser),
            progress = {
               updateProgress(audioContentLength+videoContentLength,it)
                if (it=="Finished"){
                    updateProgress(0L,finalVideoFile.absolutePath)
                    downloadsViewModel.setFinished(downloadItem.fileName)
                    audioFile.delete()
                    videoFile.delete()
                    MediaScannerConnection.scanFile(context, arrayOf(finalVideoFile.absolutePath),null
                    ) { path, uri -> println("scanned") }
                    context.sendBroadcast(
                        Intent(
                            Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                            finalVideoFile.absolutePath.toUri()
                        )
                    )
                }
            }
        )
        writter.buildNonFMp4()
    }

    fun downloadAudio(){
        if (audioFile.exists()){
            val fos= FileOutputStream(audioFile,true)
            djDownloader(
                url = downloadItem.audioUrl,
                fos = fos,
                totalBytes = audioContentLength,
                onDisk = audioFile.length(),
                progress = {inRam, speedText ->
                    updateProgress(inRam,speedText)

                }

            )
            if (downloadItem.audioUrl!=downloadItem.videoUrl){
                doMuxing()
            }else{
                updateProgress(0L,audioFile.absolutePath)
                downloadsViewModel.setFinished(downloadItem.fileName)
                MediaScannerConnection.scanFile(context, arrayOf(audioFile.absolutePath),null
                ) { path, uri -> println("scanned") }
                context.sendBroadcast(
                    Intent(
                        Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        audioFile.absolutePath.toUri()
                    )
                )
            }

        }else{
            val fos= FileOutputStream(audioFile)
            djDownloader(
                url = downloadItem.audioUrl,
                fos = fos,
                totalBytes = audioContentLength,
                onDisk =0L,
                progress = {inRam, speedText ->
                    updateProgress(inRam,speedText)
                }
            )
            if (downloadItem.audioUrl!=downloadItem.videoUrl){
                doMuxing()
            }else{
                updateProgress(0L,audioFile.absolutePath)
                downloadsViewModel.setFinished(downloadItem.fileName)
                MediaScannerConnection.scanFile(context, arrayOf(audioFile.absolutePath),null
                ) { path, uri -> println("scanned") }
                context.sendBroadcast(
                    Intent(
                        Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                        audioFile.absolutePath.toUri()
                    )
                )
            }
        }

    }

    if (downloadItem.audioUrl==downloadItem.videoUrl){
        downloadAudio()
    }else{
        if (videoFile.exists()){
            val fos= FileOutputStream(videoFile,true)
            djDownloader(
                url = downloadItem.videoUrl,
                fos = fos,
                totalBytes = videoContentLength,
                onDisk = videoFile.length(),
                progress = {inRam, speedText ->
                    updateProgress(inRam,speedText)
                }
            )
            downloadAudio()
        }else{
            val fos= FileOutputStream(videoFile)
            djDownloader(
                url = downloadItem.videoUrl,
                fos = fos,
                totalBytes = videoContentLength,
                onDisk =0L,
                progress = {inRam, speedText ->
                    updateProgress(inRam,speedText)
                }
            )
            downloadAudio()
        }
    }

}


fun djDownloader(
    url: String,
    fos: FileOutputStream,
    onDisk: Long,
    totalBytes: Long,
    progress: (inRam: Long, speedText: String) -> Unit
) {
    try {
        val chunkSize = 9 * 1024 * 1024L  // 9 MB
        val start = onDisk
        val end = minOf(start + chunkSize - 1, totalBytes - 1)

        val request = Request.Builder()
            .url(url)
            .addHeader("Range", "bytes=$start-$end")
            .build()

        val client = OkHttpClient()

        val response = client.newCall(request).execute()

        if (response.code == 206) {
            response.body?.byteStream()?.use { inputStream ->
                val buffer = ByteArray(8 * 1024) // 8 KB buffer
                var bytesRead: Int

                var downloadedInChunk = 0L
                var speedBytes = 0L
                var lastTime = System.currentTimeMillis()

                while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                    fos.write(buffer, 0, bytesRead)
                    downloadedInChunk += bytesRead
                    speedBytes += bytesRead

                    val currentDownloaded = onDisk + downloadedInChunk
                    val now = System.currentTimeMillis()

                    // Call progress callback every second
                    if (now - lastTime >= 1000) {
                        val speedText = convertSpeed(speedBytes)
                        progress(currentDownloaded, "Speed - $speedText")
                        speedBytes = 0
                        lastTime = now
                    }
                }

                // Final update after finishing the chunk
                val finalDownloaded = onDisk + downloadedInChunk
                val speedText = convertSpeed(speedBytes)
                progress(finalDownloaded, "Speed - $speedText")

                // Continue downloading if not finished
                if (finalDownloaded < totalBytes) {
                    djDownloader(url, fos, finalDownloaded, totalBytes, progress)
                }
            }
        } else {
            println("HTTP error: Expected 206 Partial Content, got ${response.code}")
        }

    } catch (e: Exception) {
        println("Download error: ${e.localizedMessage}")
        // Optionally: Report error to UI or retry logic
    }
}


fun convertBytes(sizeInBytes: Long): String {
    val kilobyte = 1024
    val megabyte = kilobyte * 1024
    val gigabyte = megabyte * 1024

    return when {
        sizeInBytes >= gigabyte -> String.format("%.2f GB", sizeInBytes.toDouble() / gigabyte)
        sizeInBytes >= megabyte -> String.format("%.2f MB", sizeInBytes.toDouble() / megabyte)
        sizeInBytes >= kilobyte -> String.format("%.2f KB", sizeInBytes.toDouble() / kilobyte)
        else -> "$sizeInBytes Bytes"
    }
}

fun convertSpeed(bytesPerSec: Long): String {
    val kilobyte = 1024.0
    val megabyte = kilobyte * 1024
    val gigabyte = megabyte * 1024

    return when {
        bytesPerSec >= gigabyte -> "${(bytesPerSec / gigabyte).roundToInt()} GB/s"
        bytesPerSec >= megabyte -> "${(bytesPerSec / megabyte).roundToInt()} MB/s"
        bytesPerSec >= kilobyte -> "${(bytesPerSec / kilobyte).roundToInt()} KB/s"
        else -> "$bytesPerSec B/s"
    }
}

fun txt2filename(txt: String): String {
    val specialCharacters = listOf(
        "@", "#", "$", "*", "&", "<", ">", "/", "\\b", "|", "?", "CON", "PRN", "AUX", "NUL",
        "COM0", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT0",
        "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9", ":", "\"", "'"
    )

    var normalString = txt
    for (sc in specialCharacters) {
        normalString = normalString.replace(sc, "")
    }

    return normalString
}
fun getTimeAgo(pastTimeMillis: Long, currentTimeMillis: Long): String {
    val diffMillis = currentTimeMillis - pastTimeMillis

    val seconds = diffMillis / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    return when {
        seconds < 60 -> "Just now"
        minutes < 60 -> "$minutes minute${if (minutes > 1) "s" else ""} ago"
        hours < 24 -> "$hours hour${if (hours > 1) "s" else ""} ago"
        else -> "$days day${if (days > 1) "s" else ""} ago"
    }
}
