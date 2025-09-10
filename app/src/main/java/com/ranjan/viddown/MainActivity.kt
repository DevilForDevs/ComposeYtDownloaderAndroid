package com.ranjan.viddown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ranjan.viddown.screens.SplashScreen
import com.ranjan.viddown.screens.downloadsScreen.DownloadsScreen
import com.ranjan.viddown.screens.linkInputScreen.LinkInputScreen
import com.ranjan.viddown.screens.login.LoginScreen
import com.ranjan.viddown.screens.models.DownloadsViewModel
import com.ranjan.viddown.screens.profileScreen.ProfileScreen
import com.ranjan.viddown.screens.signInOptions.SignInOptions
import com.ranjan.viddown.ui.theme.VidDownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VidDownTheme {
                val navController = rememberNavController()

                // Activity-scoped shared ViewModel (simplest way)
                val sharedViewModel: DownloadsViewModel = viewModel(
                    viewModelStoreOwner = LocalActivity.current as ViewModelStoreOwner
                )

                AppNavHost(navController, sharedViewModel)
            }
        }
    }
}



@Composable
fun AppNavHost(navController: NavHostController, sharedViewModel: DownloadsViewModel) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("SignInOptions") {
            SignInOptions(navController)
        }
        composable("loginScreen") {
            LoginScreen()
        }
        composable("linkInputScreen") {
            LinkInputScreen(navController,sharedViewModel) // pass shared ViewModel
        }
        composable("downloadsScreen") {
            DownloadsScreen(sharedViewModel) // also uses shared ViewModel
        }
        composable("profileScreen") {
            ProfileScreen(navController)
        }
    }
}




