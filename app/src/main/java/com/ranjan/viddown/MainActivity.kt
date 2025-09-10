package com.ranjan.viddown

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.content.FileProvider
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
import java.io.File
import androidx.core.net.toUri

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

                AppNavHost(navController, sharedViewModel, seeInGallery = {
                    openGallery(it)
                })
            }
        }
    }


    fun openGallery(filePath: String) {
        val context = this  // Activity context

        val file = File(filePath)
        if (!file.exists()) return

        // Use FileProvider to get a content:// URI
        val uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )

        val mimeType = when (file.extension.lowercase()) {
            "jpg", "jpeg", "png", "gif", "webp" -> "image/*"
            "mp4", "mkv", "3gp", "avi", "mov" -> "video/*"
            "mp3", "m4a", "wav" -> "audio/*"
            else -> "*/*"
        }

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, mimeType)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }


}



@Composable
fun AppNavHost(navController: NavHostController, sharedViewModel: DownloadsViewModel,seeInGallery:(String)-> Unit) {
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
            DownloadsScreen(
                sharedViewModel,
                seeInGallery
            ) // also uses shared ViewModel
        }
        composable("profileScreen") {
            ProfileScreen(navController)
        }
    }

}




