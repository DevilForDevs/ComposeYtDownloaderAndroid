package com.ranjan.viddown.screens.signInOptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ranjan.viddown.R
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.signInOptions.widgets.ContinueWithButtons
import com.ranjan.viddown.screens.signInOptions.widgets.DontHaveAccount
import com.ranjan.viddown.screens.signInOptions.widgets.PosterTitle
import com.ranjan.viddown.screens.signInOptions.widgets.SignInWithYourAccount


@Composable
fun SignInOptions(navController: NavController){
    DarkThemeBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_logo_light),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(150.dp)
                    .height(100.dp)
                    .padding(top = 24.dp)
            )

            PosterTitle()
            Spacer(modifier = Modifier.height(34.dp))
            ContinueWithButtons()
            Spacer(modifier = Modifier.height(34.dp))
            SignInWithYourAccount(onButtonClick = {
                navController.navigate("loginScreen")
            })
            Spacer(modifier = Modifier.height(12.dp))
            DontHaveAccount()
        }
    }

}