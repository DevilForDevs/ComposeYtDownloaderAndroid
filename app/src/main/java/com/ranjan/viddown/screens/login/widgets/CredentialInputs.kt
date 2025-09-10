package com.ranjan.viddown.screens.login.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Poppins
import com.ranjan.viddown.uiComponents.CustomBasicTextField

@Composable
fun CredentialInputs(){
    val isDark= isSystemInDarkTheme()
    Text(
        "Email Address",
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = if (isDark){Color.White}else{Color(0xFF30373D)}
    )
    Spacer(modifier = Modifier.height(12.dp))
    CustomBasicTextField("zahi.hamdard@gmail.com",false)
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        "Password",
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = if (isDark){Color.White}else{Color(0xFF30373D)}
    )
    Spacer(modifier = Modifier.height(12.dp))
    CustomBasicTextField("Password",true)
    Text(
        "Recovery Password",
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        color =Color(0xFFFF3E3E),
        textAlign = TextAlign.Right,
        fontSize = 13.sp,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 12.dp)
    )
}