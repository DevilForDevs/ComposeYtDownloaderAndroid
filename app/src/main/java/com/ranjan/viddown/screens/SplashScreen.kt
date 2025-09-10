package com.ranjan.viddown.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ranjan.viddown.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(navController: NavController) {
    val isDarkTheme = isSystemInDarkTheme()

    // Animatables for logos
    val logo1Scale = remember { Animatable(1.5f) } // start zoomed in
    val logo1Alpha = remember { Animatable(1f) }   // fully visible

    val logo2Scale = remember { Animatable(0.5f) } // start small
    val logo2Alpha = remember { Animatable(0f) }   // invisible

    // Animation sequence
    LaunchedEffect(Unit) {
        // Step 1: Logo 1 zooms out
        logo1Scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(1000, easing = FastOutSlowInEasing)
        )

        // Step 2: Fade out Logo 1 + fade in Logo 2
        launch {
            logo1Alpha.animateTo(
                targetValue = 0f,
                animationSpec = tween(500)
            )
        }
        launch {
            logo2Alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(500)
            )
        }

        // Step 3: Logo 2 zooms in
        logo2Scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(1000, easing = FastOutSlowInEasing)
        )
        navController.navigate("linkInputScreen"){
            popUpTo("splash") {
                inclusive = true  // Remove SignInOptions from back stack
            }
        }

    }

    Box(modifier = Modifier.fillMaxSize()) {
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
                    .background(Color.White)
            )
        }

        // Foreground (logos stacked & centered)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Logo 1 (old)
            Image(
                painter = painterResource(id = R.drawable.main_logo_light),
                contentDescription = "old logo",
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer(
                        scaleX = logo1Scale.value,
                        scaleY = logo1Scale.value,
                        alpha = logo1Alpha.value
                    ),
                contentScale = ContentScale.Fit
            )

            // Logo 2 (new)
            Image(
                painter = painterResource(id = R.drawable.new_logo_light),
                contentDescription = "new logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer(
                        scaleX = logo2Scale.value,
                        scaleY = logo2Scale.value,
                        alpha = logo2Alpha.value
                    ),
                contentScale = ContentScale.Fit
            )
        }
    }
}

