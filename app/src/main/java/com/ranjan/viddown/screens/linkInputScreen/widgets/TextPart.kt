package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun Textpart(){
    Text(
        "VidDown",
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color(0xFFC5C5C5),
        modifier = Modifier.padding(top = 12.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        "Your Ultimate",
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = Color(0xFFC5C5C5)
    )
    Text(
        "Downloader",
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = Color(0xFFE2E6EA)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        "\"VidDown lets you download videos instantly with speed and ease. No hassle—just seamless, uninterrupted entertainment at your fingertips!\"",
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}