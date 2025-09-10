package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Monestro
import org.json.JSONArray
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormatsDialogBox(
    sheetState: SheetState,
    closeRequest: () -> Unit,
    formats: JSONArray,
    videoTitle: String,
    selectedFormatIndex:(Int)-> Unit
) {
    val isDark = isSystemInDarkTheme()
    var selectedFmtSize by remember { mutableStateOf("") }
    var selectedFmtPosition by remember { mutableStateOf(-1) }


    ModalBottomSheet(
        onDismissRequest = { closeRequest() },
        sheetState = sheetState,
        containerColor = Color(if (isDark) 0xFF151B22 else 0xFFFFFFFF),
        contentColor = Color.White,
        tonalElevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            DialogBoxMessage(videoTitle)
            Spacer(Modifier.height(12.dp))

            Text(
                "Video",
                fontFamily = Monestro,
                fontWeight = FontWeight.Medium,
                color = Color(if (isDark) 0xFFE8E8E8 else 0xFF757575),
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))

            VideoQualityGrid(formats,false,
                onItemSelect = {
                    val fmt=formats.getJSONObject(it)
                    selectedFmtPosition=it
                    selectedFmtSize="selected File size "+convertBytes(fmt.getString("contentLength").toLong())
                })

            Spacer(Modifier.height(12.dp))

            Text(
                "Audio",
                fontFamily = Monestro,
                fontWeight = FontWeight.Medium,
                color = Color(if (isDark) 0xFFE8E8E8 else 0xFF757575),
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))

            VideoQualityGrid(formats,true, onItemSelect = {
                val fmt=formats.getJSONObject(it)
                selectedFmtPosition=it
                selectedFmtSize="selected File size "+convertBytes(fmt.getString("contentLength").toLong())
            })

            Spacer(Modifier.height(12.dp))

            Text(
                selectedFmtSize,
                color = Color(if (isDark) 0xFFC7C7C7 else 0xFF212121),
                fontFamily = Monestro,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))

            PairButtons(
                closeRequest = { closeRequest() },
                submit = {
                    selectedFormatIndex(selectedFmtPosition)
                }
            )
        }
    }
}
fun convertBytes(sizeInBytes: Long): String {
    val kilobyte = 1024
    val megabyte = kilobyte * 1024
    val gigabyte = megabyte * 1024

    return when {
        sizeInBytes >= gigabyte -> String.format(Locale.US, "%.2f GB", sizeInBytes.toDouble() / gigabyte)
        sizeInBytes >= megabyte -> String.format(Locale.US, "%.2f MB", sizeInBytes.toDouble() / megabyte)
        sizeInBytes >= kilobyte -> String.format(Locale.US, "%.2f KB", sizeInBytes.toDouble() / kilobyte)
        else -> "$sizeInBytes Bytes"
    }
}





