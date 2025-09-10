package com.ranjan.viddown.screens.signInOptions.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun DontHaveAccount(){
    Row {
        val isDark= isSystemInDarkTheme()
        Text(
            "Don’t have an Account?",
            color = Color(if (isDark){0xFFC7C7C7}else{0xFF545454}),
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
        Spacer(Modifier.width(2.dp))
        Text(
            "SIGN UP",
            color = Color(0xFFFF3E3E),
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            style = TextStyle(
                textDecoration = TextDecoration.Underline // <-- adds underline
            )

        )
    }
}