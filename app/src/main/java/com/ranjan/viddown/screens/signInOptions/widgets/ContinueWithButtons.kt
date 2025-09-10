package com.ranjan.viddown.screens.signInOptions.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun ContinueWithButtons(){
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFD9D9D9).copy(alpha = 0.2f))
            .padding(horizontal = 25.dp, vertical = 12.dp)
            .width(280.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ){
        Image(
            painter = painterResource(id = R.drawable.googleicon),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "Continue with Google"
        )


    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFD9D9D9).copy(alpha = 0.2f))
            .padding(horizontal = 25.dp, vertical = 12.dp)
            .width(280.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ){
        Image(
            painter = painterResource(id = R.drawable.applelogo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "Continue with Google"
        )


    }
}