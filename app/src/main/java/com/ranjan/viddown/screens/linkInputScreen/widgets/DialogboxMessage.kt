package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Monestro

@Composable
fun DialogBoxMessage(videoTitle: String){
    val isDark= isSystemInDarkTheme()
    Text(
        "Select Quality",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontFamily = Monestro,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        color = Color(if (isDark){0xFFFFFFFF}else{0xFF212121})
    )
    Spacer(Modifier.height(12.dp))
    Text(
        "\"$videoTitle\"",
        fontFamily = Monestro,
        fontWeight = FontWeight.Normal,
        color = Color(if (isDark){0xFFE8E8E8}else{0xFF757575}),
        fontSize = 14.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
    )
}