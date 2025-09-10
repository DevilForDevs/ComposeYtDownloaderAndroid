package com.ranjan.viddown.screens.linkInputScreen.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.R

@Composable
fun ContentSection(
    link: String,
    onLinkChange: (String) -> Unit,
    onDownloadClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .height(350.dp)
                .fillMaxWidth()
                .background(Color.Gray)  // Debug boundaries
        ) {
            Image(
                painter = painterResource(id = R.drawable.upper_body_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Textpart()
                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .width(320.dp)
                        .padding(top = 10.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(6.dp)
                ) {
                    LinkInputField(
                        text = link,
                        onTextChange = onLinkChange
                    )
                }
            }
        }

        DownloadButton(onDownloadClick = onDownloadClick)
    }
}
