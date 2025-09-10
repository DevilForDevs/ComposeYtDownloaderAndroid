package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import com.ranjan.viddown.ui.theme.OpenSans

@Composable
fun DownloadButton(onDownloadClick: () -> Unit) {
    Button(
        onClick = onDownloadClick,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF3E3E),
            contentColor = Color.White
        ),
        modifier = Modifier
            .offset(y = (-25).dp)
            .width(320.dp)
            .height(50.dp)
    ) {
        Text(
            "Download",
            fontFamily = OpenSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}