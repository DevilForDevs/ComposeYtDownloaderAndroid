package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Monestro

@Composable
fun PairButtons(closeRequest:()-> Unit,submit:()-> Unit){
    val isDark= isSystemInDarkTheme()
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                closeRequest()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isDark){Color(0xFF263238)}else{Color(0xFFC4C3C3).copy(alpha = 0.5f)},
                contentColor = Color.White
            ),
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                "Cancel",
                fontFamily = Monestro,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = if (isDark){Color.White}else{Color(0xFF212121)},
                modifier = Modifier.padding(
                    vertical = 4.dp, horizontal = 8.dp
                )
            )
        }
        Spacer(Modifier.width(20.dp))
        Button(
            onClick = {
                submit()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF3E3E),
                contentColor = Color.White
            ),
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                "Download",
                fontFamily = Monestro,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(
                    vertical = 4.dp, horizontal = 8.dp
                )
            )
        }
    }
}