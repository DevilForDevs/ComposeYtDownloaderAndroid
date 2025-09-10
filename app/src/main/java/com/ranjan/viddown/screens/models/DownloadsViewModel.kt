package com.ranjan.viddown.screens.models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class DownloadsViewModel : ViewModel() {
    private val _downloads = mutableStateListOf<DownloadItem>()
    val downloads: List<DownloadItem> = _downloads

    private val downloadsMap = mutableMapOf<String, DownloadItem>()

    fun addDownload(item: DownloadItem) {
        _downloads.add(item)
        downloadsMap[item.fileName] = item
    }
    fun updateProgress(fileName: String, inRam: Long, speed: String){
        downloadsMap[fileName]?.inRam =inRam
        downloadsMap[fileName]?.speed =speed
    }
    fun setFinished(fileName: String,){
        downloadsMap[fileName]?.isFinished =true
    }
    fun setPaused(fileName: String,){
        downloadsMap[fileName]?.isPaused =true
    }


}

