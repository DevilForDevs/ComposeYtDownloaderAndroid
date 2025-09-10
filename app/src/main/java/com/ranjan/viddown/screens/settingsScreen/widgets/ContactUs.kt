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
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun ContactUsBlock(){
    val isDark= isSystemInDarkTheme()
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color =  if (isDark){Color.White.copy(alpha = 0.2f)}else{Color.White})
            .padding(8.dp)
    ){
        SettingsItem(
            imageOrIcon = {
                Icon(
                    imageVector = Icons.Filled.HelpOutline,
                    contentDescription = "Back",
                    tint = Color(0xFF757575)
                )

            }, textOrSwitch = {

            }, title = "Help"
        )
        Spacer(modifier = Modifier.height(12.dp))
        SettingsItem(
            imageOrIcon = {
                Image(
                    painter = painterResource(id = R.drawable.termsforsettings),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            },
            textOrSwitch = {

            },
            title = "Terms & Conditions"
        )
        Spacer(modifier = Modifier.height(12.dp))
        SettingsItem(
            imageOrIcon = {
                Image(
                    painter = painterResource(id = R.drawable.privaxyforsettings),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }, textOrSwitch = {

            },
            title = "Privacy Policy"
        )
    }
}