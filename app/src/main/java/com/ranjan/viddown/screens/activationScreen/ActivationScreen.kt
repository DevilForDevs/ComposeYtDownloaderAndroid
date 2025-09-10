package com.ranjan.viddown.screens.activationScreen

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.screens.activationScreen.widgets.ActivationKeyInputField
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.login.widgets.TopBar
import com.ranjan.viddown.ui.theme.Poppins

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Dark Mode Preview"
)
@Composable
fun ActivationScreen(){
    DarkThemeBackground {
        val isDark= isSystemInDarkTheme()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "Activation",
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = if (isDark){Color.White}else{Color(0xFF212121)},
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                "“After the 7-day trial, users need an activation key from AfghanUstad.” \uD83D\uDE0A",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                color = Color(if (isDark){0xFFC7C7C7}else{0xFF707B81}),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ActivationKeyInputField()
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF3E3E), // background color
                    contentColor = Color.White          // text/icon color
                ),
                modifier = Modifier.width(320.dp)
                    .height(50.dp)
            ) {
                Text(
                    "Activate",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    "Don’t have activation key?",
                    color = if (isDark){Color(0xFFC7C7C7)}else{Color(0xFF616161)},
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                Text(
                    " Start 7-Day trial",
                    color = Color(0xFFFF3E3E),
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline // <-- adds underline
                    )

                )
            }



        }

    }

}