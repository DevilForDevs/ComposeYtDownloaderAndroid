package com.ranjan.viddown.screens.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.login.widgets.AppleGoogleButtons
import com.ranjan.viddown.screens.login.widgets.CredentialInputs
import com.ranjan.viddown.screens.login.widgets.ScreenMessage
import com.ranjan.viddown.screens.login.widgets.TopBar
import com.ranjan.viddown.screens.signInOptions.widgets.DontHaveAccount
import com.ranjan.viddown.ui.theme.Poppins


@Composable
fun LoginScreen() {
    DarkThemeBackground {
        val isDark= isSystemInDarkTheme()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(44.dp))
            ScreenMessage()
            Spacer(modifier = Modifier.height(44.dp))
            CredentialInputs()
            Spacer(modifier = Modifier.height(44.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
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
                       "Sign In With your Account",
                       fontFamily = Poppins,
                       fontWeight = FontWeight.Medium,
                       fontSize = 16.sp
                   )
               }
                Spacer(modifier = Modifier.height(44.dp))
               Text(
                   "( Or )",
                   color = if (isDark){Color.White}else{Color(0xFF616161)},
                   fontFamily = Poppins,
                   fontSize = 15.sp,
                   fontWeight = FontWeight.SemiBold
               )
                AppleGoogleButtons()
                Spacer(modifier = Modifier.height(24.dp))
                DontHaveAccount()
           }


        }

    }
}
