package com.ranjan.viddown.screens.profileScreen.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ranjan.viddown.R

@Composable
fun ActionButtons(navController: NavController){
    val isDark= isSystemInDarkTheme()

    ProfileActionRowItem(
        if (isDark){R.drawable.settingwhite}else{R.drawable.setting_icon_black},
        "settings",
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    ProfileActionRowItem(
        if (isDark){R.drawable.downloads}else{R.drawable.download_icon_black},
        "Downloads",
        onClick = {
            println("navigating")
            navController.navigate("downloadsScreen")

        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    ProfileActionRowItem(
        if (isDark){R.drawable.paper_terms}else{R.drawable.paper_terms_black},
        "Terms",
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    ProfileActionRowItem(
        if (isDark){R.drawable.hands}else{R.drawable.black_hands},
        "Privacy",
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(16.dp))
    ProfileActionRowItem(
        if (isDark){R.drawable.about}else{R.drawable.about_black},
        "About",
        onClick = {

        }
    )
}