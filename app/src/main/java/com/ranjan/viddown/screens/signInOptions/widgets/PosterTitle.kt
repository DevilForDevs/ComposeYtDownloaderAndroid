package com.ranjan.viddown.screens.signInOptions.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.R
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun PosterTitle(){
    val isDark= isSystemInDarkTheme()
    Box(modifier = Modifier.fillMaxWidth()) {

        // Rounded background only
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(if (isDark){Color(0xFFD9D9D9).copy(alpha = 0.2f)}else{Color(0xFFD9D9D9)})
        )

        // Image overlaps the background, outside bounds
        Image(
            painter = painterResource(id = R.drawable.manwithaccount),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 10.dp) // feet overflow
        )
    }
    Text(
        "Let’s get in",
        modifier = Modifier.padding(top = 30.dp),
        color = if (isDark){Color.White}else{Color(0xFF202244)},
        fontSize = 24.sp,
        fontFamily = Poppins
    )
    Text(
        "We Are Happy To Help With Your Learning Journey, Lets Dive in By Registering.",
        color = if (isDark){Color(0xFFC7C7C7)}else{Color(0xFF707B81)},
        fontSize = 14.sp,
        fontFamily = Poppins,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 4.dp)
    )
}