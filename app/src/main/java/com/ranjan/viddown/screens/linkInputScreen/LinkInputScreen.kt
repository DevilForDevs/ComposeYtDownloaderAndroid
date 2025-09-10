package com.ranjan.viddown.screens.linkInputScreen

import android.content.Context
import android.os.Environment
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.linkInputScreen.widgets.ContentSection
import com.ranjan.viddown.screens.linkInputScreen.widgets.Footer
import com.ranjan.viddown.screens.linkInputScreen.widgets.FormatsDialogBox
import com.ranjan.viddown.screens.linkInputScreen.widgets.SupportedPlatforms
import com.ranjan.viddown.screens.linkInputScreen.widgets.TopBar
import com.ranjan.viddown.screens.models.DownloadItem
import com.ranjan.viddown.screens.models.DownloadsViewModel
import com.ranjan.viddown.screens.utils.LinksManager
import com.ranjan.viddown.screens.utils.addToDownloadsList
import com.ranjan.viddown.screens.utils.txt2filename
import com.ranjan.viddown.ui.theme.Raleway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinkInputScreen(navController: NavController,downloadsViewModel: DownloadsViewModel) {
    val isDark = isSystemInDarkTheme()
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var link by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    var currentVideo= JSONObject()
    val context=LocalContext.current



    DarkThemeBackground {
        Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp)) {
            TopBar(onMenuClick = {
                navController.navigate("profileScreen")
            })
            Spacer(Modifier.height(12.dp))

            ContentSection(
                link = link,
                onLinkChange = { link = it },
                onDownloadClick = {
                    coroutineScope.launch {
                        withContext(Dispatchers.IO){
                            val resp=LinksManager(link)
                            currentVideo= resp
                            showSheet=true
                            link=""
                        }

                    }

                }
            )

            Text(
                "Supported Platforms",
                fontFamily = Raleway,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = Color(if (isDark) 0xFFE2E6EA else 0xFF696A6B),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            SupportedPlatforms()
            Footer()

            if (showSheet) {
                val formats = currentVideo.optJSONArray("formats") ?: JSONArray()
                val videoTitle=txt2filename(currentVideo.optString("title")?:"Video Not found")
                FormatsDialogBox(
                    sheetState = sheetState,
                    closeRequest = { showSheet = false },
                    formats = formats,
                    videoTitle = videoTitle,
                    selectedFormatIndex = {
                        showSheet = false
                        coroutineScope.launch(Dispatchers.IO){
                            val videoFmt=formats.getJSONObject(it)

                            if (videoFmt.getString("mimeType").contains("video")){

                                for (i in 0 until formats.length()) {
                                    val fmt = formats.getJSONObject(i)
                                    if (fmt.getInt("itag")==140){
                                        addToDownloadsList(
                                            downloadList = downloadsViewModel,
                                            title = videoTitle,
                                            videoFmt = videoFmt,
                                            audioFmt = fmt,
                                            thumbnail = currentVideo.getString("thumbnail"),
                                            context = context
                                        )
                                    }
                                }

                            }else{
                                addToDownloadsList(
                                    downloadList = downloadsViewModel,
                                    title = videoTitle,
                                    videoFmt = videoFmt,
                                    audioFmt = videoFmt,
                                    thumbnail = currentVideo.getString("thumbnail"),
                                    context = context
                                )
                            }


                        }

                    }
                )
            }


        }
    }
}


