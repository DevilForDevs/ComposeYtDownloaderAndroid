package com.ranjan.viddown.screens.profileScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ranjan.viddown.R
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.profileScreen.widgets.ActionButtons
import com.ranjan.viddown.screens.profileScreen.widgets.NamePhoto
import com.ranjan.viddown.screens.profileScreen.widgets.TopBar
import com.ranjan.viddown.ui.theme.Poppins



@Composable
fun ProfileScreen(navController: NavController){
    DarkThemeBackground(){
        val isDark= isSystemInDarkTheme()
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ){
            TopBar(
                onBack = {
                    navController.popBackStack()
                }
            )
            NamePhoto()
            Spacer(modifier = Modifier.height(24.dp))
            ActionButtons(navController)
            Spacer(modifier = Modifier.height(200.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = if (isDark){R.drawable.sign_out}else{R.drawable.log_out_black}),
                    contentDescription = null,
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    "Sign Out",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = if (isDark){Color.White}else{Color(0xFF151B22)}
                )
            }

        }
    }
}