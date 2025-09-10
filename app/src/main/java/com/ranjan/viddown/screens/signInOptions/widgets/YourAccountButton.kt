package com.ranjan.viddown.screens.signInOptions.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun SignInWithYourAccount(onButtonClick:()-> Unit){
    val isDark= isSystemInDarkTheme()
    Text(
        "( Or )",
        color = if (isDark){Color.White}else{Color(0xFF545454)},
        fontFamily = Poppins,
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(34.dp))
    Button(
        onClick = {
            onButtonClick()
        },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF3E3E), // background color
            contentColor = Color.White          // text/icon color
        ),
        modifier = Modifier.width(320.dp)
            .height(50.dp)
    ) {
        Text(
            "Sign In With your Account",
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
    }
}