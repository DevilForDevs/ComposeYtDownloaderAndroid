package com.ranjan.viddown.screens.downloadsScreen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.screens.models.DownloadItem
import com.ranjan.viddown.screens.utils.convertBytes
import com.ranjan.viddown.screens.utils.getTimeAgo
import com.ranjan.viddown.ui.theme.Poppins

@Composable
fun DownloadItemUI(downloadItem: DownloadItem,seeInGallery:(String)-> Unit) {
    val isDark = isSystemInDarkTheme()

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(if (isDark) Color.White.copy(alpha = 0.2f) else Color.White)
            .padding(all = 12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                downloadItem.fileName,
                color = if (isDark) Color.White else Color(0xFF151B22),
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(200.dp),
                maxLines = 1
            )

            val currentTimeMillis = System.currentTimeMillis()
            Text(
                getTimeAgo(downloadItem.downloadStartTime, currentTimeMillis),
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                color = if (isDark) Color(0xFFEBEBEB) else Color(0xFF9298A0),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (downloadItem.isFinished) {
            // Only show total
            Text(
                "Total: ${convertBytes(downloadItem.onWebInitial)}",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = if (isDark) Color.White else Color(0xFF212121)
            )
            Text(
                "See in Gallery",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = if (isDark) Color(0xFFEBEBEB) else Color(0xFF9298A0),
                modifier = Modifier.fillMaxWidth()
                    .clickable(
                        onClick = {
                            seeInGallery(downloadItem.speed)
                        }
                    ),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

        } else {
            // Show remaining, progress bar, and speed
            Text(
                "Total ${convertBytes(downloadItem.onWebInitial)} - Remaining ${convertBytes(downloadItem.onWebInitial - downloadItem.inRam)}",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = if (isDark) Color.White else Color(0xFF212121)
            )

            Spacer(modifier = Modifier.height(8.dp))

            val progress = if (downloadItem.onWebInitial > 0) {
                downloadItem.inRam.toFloat() / downloadItem.onWebInitial.toFloat()
            } else {
                0f
            }

            CustomBoxProgressBar(
                progress = progress.coerceIn(0f, 1f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                downloadItem.speed,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = if (isDark) Color.White else Color(0xFF19A3FF)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Cancel Downloading",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = if (isDark) Color(0xFFEBEBEB) else Color(0xFF9298A0),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
        }


    }
}
