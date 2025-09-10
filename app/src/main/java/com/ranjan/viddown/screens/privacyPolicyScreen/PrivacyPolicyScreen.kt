package com.ranjan.viddown.screens.privacyPolicyScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.ranjan.viddown.screens.termsconditions.widgets.PolicyRow
import com.ranjan.viddown.screens.termsconditions.widgets.SubHeading
import com.ranjan.viddown.screens.termsconditions.widgets.SubHeadingSub
import com.ranjan.viddown.screens.termsconditions.widgets.Title

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode Preview"
)
@Composable
fun PrivacyPolicyScreen(){
    DarkThemeBackground {

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState())
        ){
            TopBar("Privacy Policy")
            Title("Introduction")
            Spacer(Modifier.height(12.dp))
            SubHeading("Welcome to VidDown! This privacy policy outlines how we collect, use, and protect your personal information when you use our platform. By accessing or using VidDown, you agree to the terms described in this policy.")
            Spacer(Modifier.height(12.dp))
            Title("Information We Collect")
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("1. Personal Information:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("When you register or use our services, we may collect personal information such as your name, email address, and other relevant details.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "We may also collect information related to your educational preferences, browsing behavior, and interactions with our content."
                )

            }
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("2. Usage Data:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We automatically collect data about your interactions with VidDown, including your IP address, device type, browser, and pages visited.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "This data helps us improve our services and enhance your experience."
                )

            }
            Spacer(Modifier.height(12.dp))
            Title("How We Use Your Information")
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("1. Providing Services:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We use your personal information to deliver educational content, respond to inquiries, and improve our offerings.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "Your data helps us customize recommendations and track your progress."
                )

            }
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("2. Analytics and Research:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We analyze usage patterns to enhance our platform, identify trends, and optimize content delivery.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "Aggregated data may be shared with third parties for research purposes."
                )

            }
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("2. Communication:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We may send you updates, newsletters, or promotional materials related to VidDown.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "You can opt out of these communications at any time."
                )

            }
            Spacer(Modifier.height(12.dp))
            Title("Data Security")
            Spacer(Modifier.height(12.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We take reasonable measures to protect your information from unauthorized access, loss, or misuse.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "However, no system is entirely secure, and we cannot guarantee absolute data security."
                )

            }
            Spacer(Modifier.height(12.dp))
            Title("Your Rights")
            Spacer(Modifier.height(12.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("You have the right to access, correct, or delete your personal information.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "To exercise these rights, please contact us using the provided contact details."
                )

            }
            Spacer(Modifier.height(12.dp))
            Title("Changes to this Policy")
            Spacer(Modifier.height(12.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We may update this privacy policy periodically. Any significant changes will be communicated to users.")


            }
            Spacer(Modifier.height(12.dp))
            Title("Contact Us")
            Spacer(Modifier.height(8.dp))
            SubHeadingSub("If you have any questions or concerns regarding our privacy practices, please reach out to us at contact@VidDown.com.")



        }
    }

}