package com.ranjan.viddown.screens.login.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
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
fun ScreenMessage(){
    val isDark= isSystemInDarkTheme()
    Text(
        "Hello Again!",
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        color = if (isDark){Color.White}else{Color(0xFF212121)},
        textAlign = TextAlign.Center,
        fontSize = 26.sp,
        modifier = Modifier.fillMaxWidth()
    )
    Text(
        "Welcome Back You’ve Been Missed!",
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        color = Color(if (isDark){0xFFC7C7C7}else{0xFF707B81}),
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 8.dp)
    )
}