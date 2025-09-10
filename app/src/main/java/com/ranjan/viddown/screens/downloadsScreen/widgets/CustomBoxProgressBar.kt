package com.ranjan.viddown.screens.downloadsScreen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomBoxProgressBar(
    progress: Float, // Range: 0f..1f
    modifier: Modifier = Modifier,
    height: Dp = 10.dp,
    progressColor: Color = Color(0xFF19A3FF)
) {
    val isDark= isSystemInDarkTheme()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(4.dp))
            .border(width = 2.dp, color = if (isDark){Color.White.copy(alpha = 0.5f)}else{Color(0xFF0961F5).copy(alpha = 0.3f)}, shape = RoundedCornerShape(4.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .background(progressColor)
                .clip(RoundedCornerShape(4.dp))
                .align(Alignment.CenterStart)  // Important: Ensure progress starts from left
        )
    }
}


