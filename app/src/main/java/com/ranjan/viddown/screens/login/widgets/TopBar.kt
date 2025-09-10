package com.ranjan.viddown.screens.login.widgets

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun TopBar(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        val isDark= isSystemInDarkTheme()
        // Logo in center


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
                tint = Color.Black
            )
        }
        Image(
            painter = painterResource(id = if (isDark){R.drawable.logo}else{R.drawable.main_logo_light}),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
        )

    }
}