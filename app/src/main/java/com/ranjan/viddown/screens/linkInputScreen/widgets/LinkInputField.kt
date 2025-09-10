package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.R

@Composable
fun LinkInputField(
    text: String,
    onTextChange: (String) -> Unit
) {
    BasicTextField(
        value = text,
        onValueChange = onTextChange,
        textStyle = TextStyle(fontSize = 18.sp),
        modifier = Modifier
            .height(50.dp)
            .background(Color(0xFFE2E6EA), shape = RoundedCornerShape(50.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.link_break),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (text.isEmpty()) {
                        androidx.compose.material3.Text(
                            "insert your video link here...",
                            fontSize = 18.sp,
                            color = Color(0xFF696A6B)
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}
