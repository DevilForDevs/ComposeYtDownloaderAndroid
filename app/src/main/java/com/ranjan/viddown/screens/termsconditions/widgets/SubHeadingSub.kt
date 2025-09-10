package com.ranjan.viddown.screens.termsconditions.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun SubHeadingSub(text: String){
    val isDark= isSystemInDarkTheme()
    Text(
        text,
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        color = if (isDark){Color.White}else{Color(0xFF151B22)},
        modifier = Modifier.padding(start = 15.dp)
    )
}