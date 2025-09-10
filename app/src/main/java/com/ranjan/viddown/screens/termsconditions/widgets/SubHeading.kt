package com.ranjan.viddown.screens.termsconditions.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun SubHeading(text: String){
    val isDark= isSystemInDarkTheme()
    Text(
        text,
        color = Color(if (isDark){0xFFB4B4B4}else{0xFF616161}),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Left,
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,

    )
}