package com.ranjan.viddown.screens.settingsScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.R
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun TopBar(title: String){
    val isDark= isSystemInDarkTheme()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        // Logo in center
        Text(
            title,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = if (isDark){Color.White}else{Color(0xFF151B22)}
        )

        // Arrow at end (right)
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(45.dp)
                .background(if (isDark){Color(0xFFD9D9D9).copy(alpha = 0.2f)}else{Color.White}, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = "Back",
                tint = Color(0xFF151B22)
            )
        }

    }
}