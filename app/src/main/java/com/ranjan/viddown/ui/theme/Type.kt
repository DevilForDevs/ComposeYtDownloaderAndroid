package com.ranjan.viddown.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
val Poppins = FontFamily(
    Font(R.font.poppins_regular, weight = FontWeight.Normal),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
    Font(R.font.poppins_medium, weight = FontWeight.Medium)
)
val OpenSans = FontFamily(
    Font(R.font.opensans_semibold, weight = FontWeight.SemiBold)
)
val Raleway = FontFamily(
    Font(R.font.raleway_medium, weight = FontWeight.Medium)
)
val Monestro = FontFamily(
    Font(R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(R.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(R.font.montserrat_medium, weight = FontWeight.Medium)
)