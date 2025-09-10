package com.ranjan.viddown.screens.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class DownloadItem(
    val fileName: String,
    val thumbnailUrl: String,
    val videoUrl: String,
    val audioUrl: String,
    val downloadStartTime: Long,
    val onDiskInitial: Long = 0,
    val onWebInitial: Long = 0,
    val inRamInitial: Long,
    val speedInitial: String = "",
    val isFinishedInitial: Boolean = false,
    val isPausedInitial: Boolean = false,
) {
    // Observable fields
    var inRam by mutableStateOf(inRamInitial)
    var speed by mutableStateOf(speedInitial)
    var isFinished by mutableStateOf(isFinishedInitial)
    var isPaused by mutableStateOf(isPausedInitial)
}

