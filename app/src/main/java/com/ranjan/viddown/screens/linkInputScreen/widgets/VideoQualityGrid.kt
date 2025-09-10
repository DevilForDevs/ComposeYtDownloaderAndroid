package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranjan.viddown.ui.theme.Monestro
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun VideoQualityGrid(
    formats: JSONArray,
    audioFmts: Boolean,
    onItemSelect: (Int) -> Unit
) {
    val isDark = isSystemInDarkTheme()
    var selectedIndex by remember { mutableIntStateOf(-1) } // Track clicked item

    // Step 1: Filter the formats based on audioFmts
    val filteredFormats = mutableListOf<JSONObject>()
    val originalIndices = mutableListOf<Int>() // Keep track of original indices

    for (i in 0 until formats.length()) {
        val fmt = formats.getJSONObject(i)
        val mimeType = fmt.optString("mimeType", "")
        val hasBitrate = fmt.has("bitrate")
        val hasQualityLabel = fmt.has("qualityLabel")

        if (audioFmts) {
            if (mimeType.startsWith("audio/", ignoreCase = true) && hasBitrate && fmt.has("itag")) {
                filteredFormats.add(fmt)
                originalIndices.add(i)
            }
        } else {
            if (hasQualityLabel) {
                filteredFormats.add(fmt)
                originalIndices.add(i)
            }
        }
    }

    // Step 2: Display filteredFormats in a grid
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(filteredFormats.size) { index ->
            val fmt = filteredFormats[index]
            val displayText = if (audioFmts) {
                val bitrate = formatBitrate(fmt.getString("bitrate").toLong())
                "$bitrate/s"
            } else {
                fmt.getString("qualityLabel")
            }

            val isSelected = selectedIndex == index
            val boxColor = when {
                isSelected && isDark -> Color(0xFF616161)
                isSelected && !isDark -> Color(0xFFFF4B4B).copy(alpha = 0.5f)
                isDark -> Color(0xFF263238).copy(alpha = 0.5f)
                else -> Color(0xFFC4C3C3).copy(alpha = 0.2f)
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(boxColor)
                    .padding(horizontal = 15.dp, vertical = 6.dp)
                    .clickable {
                        selectedIndex = index
                        onItemSelect(originalIndices[index])
                    }
            ) {
                Text(
                    text = displayText,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (isDark) Color.White else Color(0xFF151B22),
                    fontFamily = Monestro,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}






fun formatBitrate(speedT: Long): String {
    return when {
        speedT >= 1_000_000_000 -> "${speedT / 1_000_000_000} G"
        speedT >= 1_000_000     -> "${speedT / 1_000_000} M"
        speedT >= 1_000         -> "${speedT / 1_000} K"
        else                    -> "${speedT} B"
    }
}
