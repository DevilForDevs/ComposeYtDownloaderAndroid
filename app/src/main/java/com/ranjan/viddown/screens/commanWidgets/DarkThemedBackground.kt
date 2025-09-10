package com.ranjan.viddown.screens.commanWidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.ranjan.viddown.R

@Composable
fun DarkThemeBackground(
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()

    Scaffold { paddingValues ->  // Provide system insets padding
        Box(modifier = modifier.fillMaxSize()) {

            // Background
            if (isDarkTheme) {
                Image(
                    painter = painterResource(id = R.drawable.dark_background),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFE8E8E8))
                )
            }

            // Foreground content with Scaffold padding
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)  // Avoid overlapping topBar, bottomBar, etc.
            ) {
                content(paddingValues)
            }
        }
    }
}

