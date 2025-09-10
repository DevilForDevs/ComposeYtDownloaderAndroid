package com.ranjan.viddown.screens.downloadsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.downloadsScreen.widgets.DownloadItemUI
import com.ranjan.viddown.screens.models.DownloadsViewModel
import com.ranjan.viddown.screens.settingsScreen.widgets.TopBar


@Composable
fun DownloadsScreen(downloadsList: DownloadsViewModel,seeInGallery:(String)-> Unit){

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
                    DownloadItemUI(downloadsList.downloads[index],seeInGallery)
                    Spacer(modifier = Modifier.height(8.dp))
                }

            }
        }

    }

}