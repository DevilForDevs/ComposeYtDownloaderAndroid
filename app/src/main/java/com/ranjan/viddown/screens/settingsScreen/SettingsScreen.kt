package com.ranjan.viddown.screens.settingsScreen

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.settingsScreen.widgets.ContactUsBlock
import com.ranjan.viddown.screens.settingsScreen.widgets.SettingsAndPreferences
import com.ranjan.viddown.screens.settingsScreen.widgets.SettingsItem
import com.ranjan.viddown.screens.settingsScreen.widgets.TopBar
import com.ranjan.viddown.ui.theme.Poppins

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Dark Mode Preview"
)

@Composable
fun SettingsScreen(){
    DarkThemeBackground {
        val isDark= isSystemInDarkTheme()
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ){
            TopBar("Settings")
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Location",
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = if (isDark){Color.White}else{Color(0xFF757575)}
            )
            Spacer(modifier = Modifier.height(12.dp))
            SettingsItem(imageOrIcon = {
                Icon(
                    imageVector = Icons.Filled.MyLocation,
                    contentDescription = "Back",
                    tint =Color(0xFF757575)
                )
            }, textOrSwitch = {
                Text(
                    "Change",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color(0xFF19A3FF),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline // <-- adds underline
                    )

                )
            }, title = "Kabul")
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Settings and Preferences",
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = if (isDark){Color.White}else{Color(0xFF757575)}
            )
            Spacer(modifier = Modifier.height(6.dp))
            SettingsAndPreferences()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Contact Us",
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = if (isDark){Color.White}else{Color(0xFF757575)}
            )
            Spacer(modifier = Modifier.height(6.dp))
            ContactUsBlock()

        }

    }
}