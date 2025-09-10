package com.ranjan.viddown.screens.profileScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.ranjan.viddown.ui.theme.Monestro

@Composable
fun ProfileActionRowItem(resId: Int,text: String,onClick:()-> Unit){
    val isDark= isSystemInDarkTheme()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(
            onClick = {
                onClick()
            }
        )
    ){
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            modifier = Modifier
                .height(25.dp)
                .width(25.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text,
            fontFamily = Monestro,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color =if (isDark){Color.White}else{Color(0xFF151B22)}
        )
    }
}