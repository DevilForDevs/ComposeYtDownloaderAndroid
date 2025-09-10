package com.ranjan.viddown.screens.profileScreen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(onBack:()-> Unit){
    val isDark= isSystemInDarkTheme()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(45.dp)
                .background(if (isDark){Color(0xFFD9D9D9).copy(alpha = 0.2f)}else{Color.White}, shape = CircleShape)
                .clickable(
                    onClick = {
                        onBack()
                    }
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = "Back",
                tint =if (isDark){ Color.Black}else{ Color(0xFF151B22)}
            )
        }

    }
}