package com.ranjan.viddown.screens.aboutScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.screens.termsconditions.widgets.SubHeading

@Composable
fun AboutRow(title: String,text: String){
    Row(
    ){
        Box(
            modifier = Modifier
                .padding(top = 5.dp)
                .clip(shape = CircleShape)
                .height(5.dp)
                .width(5.dp)
                .background(color = Color(0xFFB4B4B4))

        ){

        }
        Spacer(Modifier.width(4.dp))
        Text(title, color = Color.White)
        Spacer(Modifier.width(4.dp))
        SubHeading(text)
    }
}