package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun SupportedPlatforms(){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 24.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(30.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier.height(30.dp)
                .width(2.dp)
                .background(color = Color(0xFFB4B4B4))
        ){

        }
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(30.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier.height(30.dp)
                .width(2.dp)
                .background(color = Color(0xFFB4B4B4))
        ){

        }
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.youtube),
            contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(43.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier.height(30.dp)
                .width(2.dp)
                .background(color = Color(0xFFB4B4B4))
        ){

        }
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.tiktok),
            contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(30.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(10.dp))


    }
}