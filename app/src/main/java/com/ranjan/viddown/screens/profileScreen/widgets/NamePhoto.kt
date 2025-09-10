package com.ranjan.viddown.screens.profileScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.R
import com.ranjan.viddown.ui.theme.Monestro
import com.ranjan.viddown.ui.theme.Raleway

@Composable
fun NamePhoto(){
    val isDark= isSystemInDarkTheme()
    Image(
        painter = painterResource(id = R.drawable.person),
        contentDescription = null,
        modifier = Modifier
            .height(50.dp)
            .width(50.dp),
        contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        "Hello, \uD83D\uDC4B",
        fontFamily = Monestro,
        fontWeight = FontWeight.Normal,
        color = Color(0xFF9298A0),
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        "Zahid Hamdard",
        fontFamily = Raleway,
        fontWeight = FontWeight.SemiBold,
        color = if(isDark){Color.White}else{Color(0xFF151B22)},
        fontSize = 24.sp
    )
}