package com.ranjan.viddown.screens.downloadsScreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.screens.downloadsScreen.widgets.CustomBoxProgressBar
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.downloadsScreen.widgets.DownloadItemUI
import com.ranjan.viddown.screens.models.DownloadsViewModel
import com.ranjan.viddown.screens.settingsScreen.widgets.TopBar
import com.ranjan.viddown.ui.theme.Poppins


@Composable
fun DownloadsScreen(downloadsList: DownloadsViewModel){

    DarkThemeBackground(


    ){
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ){
            TopBar("Downloads")
            Spacer(Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(downloadsList.downloads.size){index->
                    DownloadItemUI(downloadsList.downloads[index])
                    Spacer(modifier = Modifier.height(8.dp))
                }

            }
        }

    }

}