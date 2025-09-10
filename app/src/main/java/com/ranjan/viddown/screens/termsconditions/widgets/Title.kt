package com.ranjan.viddown.screens.termsconditions.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun Title(text: String ){
    val isDark= isSystemInDarkTheme()
    Text(
        text,
        fontFamily = Poppins,
        fontSize = 18.sp,
        color = if (isDark){Color.White}else{Color(0xFF151B22)}

    )
}