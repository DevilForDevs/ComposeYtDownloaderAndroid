package com.ranjan.viddown.screens.settingsScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.R
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun SettingsAndPreferences(){
    val isDark= isSystemInDarkTheme()
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color =  if (isDark){Color.White.copy(alpha = 0.2f)}else{Color.White})
            .padding(8.dp)
    ){
        SettingsItem(imageOrIcon = {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Back",
                tint = Color(0xFF757575)
            )
        },
            textOrSwitch = {
                var isChecked by remember { mutableStateOf(false) }
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        uncheckedThumbColor = Color.Gray,
                        checkedTrackColor = Color(0xFF3A81F7),
                        uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier.height(20.dp)
                )
            }, title = "Notifications")

        Spacer(modifier = Modifier.height(12.dp))
        SettingsItem(
            imageOrIcon = {
                Image(
                    painter = painterResource(id = R.drawable.show_progress),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            },
            textOrSwitch = {
                var isChecked by remember { mutableStateOf(true) }
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        uncheckedThumbColor = Color.Gray,
                        checkedTrackColor = Color(0xFF3A81F7),
                        uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier.height(20.dp)
                )
            },
            title = "Show Progress"
        )
        Spacer(modifier = Modifier.height(12.dp))
        SettingsItem(
            imageOrIcon = {
                Image(
                    painter = painterResource(id = R.drawable.apperance),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            },
            textOrSwitch = {
                Text(
                    "Use Device Settings",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color(0xFF19A3FF),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline // <-- adds underline
                    )

                )
            }, title = "Appearance"
        )
        Spacer(modifier = Modifier.height(12.dp))
        SettingsItem(
            imageOrIcon = {
                Icon(
                    imageVector = Icons.Filled.Translate,
                    contentDescription = "Back",
                    tint = Color(0xFF757575)
                )
            },
            textOrSwitch = {
                Text(
                    "English",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color(0xFF19A3FF),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline // <-- adds underline
                    )

                )
            }, title = "Preferred App Language"
        )
    }
}