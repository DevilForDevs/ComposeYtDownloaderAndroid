package com.ranjan.viddown.screens.settingsScreen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun SettingsItem(
    imageOrIcon: @Composable () -> Unit,
    textOrSwitch: @Composable () -> Unit,
    title: String
) {
    val isDark= isSystemInDarkTheme()
    Box(
        modifier = Modifier.fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = if (isDark){Color.White.copy(alpha = 0.8f)}else{Color(0xFFF5F5F5)})
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(50.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    imageOrIcon()  // ✅ Works fine now
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    title,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color(0xFF151B22)
                )
            }

            textOrSwitch()  // ✅ Works fine now
        }
    }
}
