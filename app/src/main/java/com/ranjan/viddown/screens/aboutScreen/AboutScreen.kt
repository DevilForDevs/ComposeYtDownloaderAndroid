package com.ranjan.viddown.screens.aboutScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ranjan.viddown.screens.commanWidgets.DarkThemeBackground
import com.ranjan.viddown.screens.settingsScreen.widgets.TopBar
import com.ranjan.viddown.screens.termsconditions.widgets.SubHeading
import com.ranjan.viddown.screens.termsconditions.widgets.Title

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode Preview"
)
@Composable
fun AboutScreen(){
    DarkThemeBackground {

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState())
        ){
            TopBar("Privacy Policy")
            Spacer(Modifier.height(12.dp))
            Title("AfghanUstad App")
            Spacer(Modifier.height(8.dp))
            SubHeading("VidDown, an established online educational platform in Afghanistan, has been operating since 2000 with the mission of making education accessible to all. By leveraging digital resources, VidDown aims to facilitate learning from the comfort of one’s home.\n" +
                    "The platform provides video content and other educational materials, ensuring that knowledge reaches every corner of the country")
            Column(
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp)
            ){
                AboutRow(title = "Mission:", text = " VidDown has been operating since 2000 with a noble mission: to make education accessible to all in Afghanistan.")
                Spacer(Modifier.height(8.dp))
                AboutRow(title = "Platform:", text = "It is an online educational platform that leverages digital resources to facilitate learning from the comfort of one’s home.")
                Spacer(Modifier.height(8.dp))
                AboutRow(title = "Content:", text = "VidDown provides a rich array of educational materials, including video content, lectures, and other resources.")
                Spacer(Modifier.height(8.dp))
                AboutRow(title = "Accessibility:", text = "By offering digital access, VidDown ensures that knowledge reaches every corner of the country, even in remote areas.")
                Spacer(Modifier.height(8.dp))
                AboutRow(title = "Rights:", text = " All rights to the videos and content exclusively belong to VidDown, emphasizing their commitment to quality and authenticity.")
                Spacer(Modifier.height(8.dp))
                AboutRow(title = "Impact:", text = " Through its efforts, VidDown contributes significantly to empowering Afghan learners, bridging educational gaps, and fostering a culture of lifelong learning.")
            }
            Spacer(Modifier.height(12.dp))
            SubHeading("VidDown dedication to education reflects its role as a beacon of knowledge and empowerment in Afghanistan. ")

        }
    }
}
