package com.ranjan.viddown.screens.login.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun AppleGoogleButtons(){
    Row(
        modifier = Modifier.padding(
            top = 24.dp
        )
    ){
        val isDark= isSystemInDarkTheme()
        Button(
            onClick = {

            },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isDark){Color(0xFFD9D9D9).copy(alpha = 0.2f)}else{Color.White}, // background color
                contentColor = Color.White          // text/icon color
            ),
            modifier = Modifier.width(140.dp)
                .height(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.googleicon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Button(
            onClick = {

            },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isDark){Color(0xFFD9D9D9).copy(alpha = 0.2f)}else{Color.White},
                contentColor = Color.White          // text/icon color
            ),
            modifier = Modifier.width(140.dp)
                .height(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.applelogo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}