package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun TopBar(onMenuClick:()-> Unit){
    val dark= isSystemInDarkTheme()
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            painter = painterResource(id = if (dark){R.drawable.logo}else{R.drawable.main_logo_light}),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
        )
        Row {
            Image(
                painter = painterResource(id = if (dark){R.drawable.theme}else{R.drawable.moon}),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )
            Image(
                painter = painterResource(id =if (dark){R.drawable.menus}else{R.drawable.menulight}),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .clickable(
                        onClick = {
                            onMenuClick()
                        }
                    )
            )
        }

    }
}