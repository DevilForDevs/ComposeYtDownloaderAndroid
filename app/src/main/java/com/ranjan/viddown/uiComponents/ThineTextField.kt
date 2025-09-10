package com.ranjan.viddown.uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomBasicTextField(hint: String,showTrailing: Boolean) {
    var text by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }
    val isDark= isSystemInDarkTheme()

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(fontSize = 18.sp),
        modifier = Modifier
            .height(50.dp)
            .background(if (isDark){Color(0xFFD9D9D9).copy(alpha = 0.2f)}else{Color.White}, shape = RoundedCornerShape(50.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,

            ) {
                Spacer(modifier = Modifier.width(8.dp))

                // ✅ Actual Input Field
                Box(modifier = Modifier.weight(1f)) {
                    if (text.isEmpty()) {
                        androidx.compose.material3.Text(
                            hint,
                            fontSize = 18.sp,
                            color = if (isDark){Color.White}else{Color(0xFF30373D)},
                        )
                    }
                    innerTextField()
                }

                Spacer(modifier = Modifier.width(8.dp))

                if (showTrailing){
                    Icon(
                        imageVector = if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null,
                        tint = if (isDark){Color.White}else{Color(0xFF30373D)},
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 4.dp)
                            .clickable { isVisible = !isVisible }
                    )
                }
            }
        }
    )
}