package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun Footer(){
    val isDark= isSystemInDarkTheme()
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = null,
            modifier = Modifier
                .height(60.dp)
                .width(50.dp),
            contentScale = ContentScale.Fit
        )
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 24.dp)
    ){
        Image(
            painter = painterResource(id = if (isDark){R.drawable.new_logo}else{R.drawable.new_logo_light}),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}