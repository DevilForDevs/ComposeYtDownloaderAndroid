package com.ranjan.viddown.screens.termsconditions

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
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Dark Mode Preview"
)
@Composable
fun TermsAndConditions(){
    DarkThemeBackground {

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState())
        ){
            TopBar("Terms & Conditions")
            Spacer(Modifier.height(12.dp))
            Title("Introduction")
            Spacer(Modifier.height(12.dp))
            SubHeading("Welcome to VidDown! These terms and conditions govern your use of our educational platform. By accessing or using VidDown, you agree to comply with these terms. If you disagree with any part of these terms, please refrain from using our services.")
            Spacer(Modifier.height(12.dp))
            Title("User Responsibilities")
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("1.   Access and Use:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("You may access AfghanUstad for educational purposes only.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "Do not misuse, modify, or distribute our content without authorization."
                )
            }
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("2.   Account Registration:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("When creating an account, provide accurate information.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "Keep your login credentials secure and confidential."
                )
            }
            Spacer(Modifier.height(12.dp))
            Title("Privacy and Data Protection")
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("1.   Data Collection:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We collect necessary user data for account creation and personalized experiences.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "Review our privacy policy for details on data handling."
                )
            }
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("2.   Cookies and Tracking:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("VidDown uses cookies for analytics and functionality.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "You can manage cookie preferences in your browser settings."
                )
            }
            Spacer(Modifier.height(12.dp))
            Title("Intellectual Property")
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("1.   Ownership:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("All content on VidDown, including videos, text, and graphics, belongs to us or our licensors.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "You may not reproduce, distribute, or exploit our content without permission."
                )
            }
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("2.   User-Generated Content:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("By contributing content (comments, posts, etc.), you grant us a non-exclusive license to use, modify, and distribute it.")

            }
            Spacer(Modifier.height(12.dp))
            Title("Limitation of Liability")
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("1.   Disclaimer:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("VidDown provides content “as is” without warranties.")
                Spacer(Modifier.height(8.dp))
                PolicyRow(
                    "We are not liable for any direct, indirect, or consequential damages arising from platform use."
                )

            }
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("2.   Third-Party Links:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("VidDown may contain links to external websites. We are not responsible for their content or practices.")


            }
            Title("Termination")
            Spacer(Modifier.height(12.dp))
            SubHeadingSub("1.   Suspension or Termination:")
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 26.dp, top = 8.dp)
            ){
                PolicyRow("We reserve the right to suspend or terminate accounts violating these terms.")
                Spacer(Modifier.height(8.dp))
                PolicyRow("Users may also terminate their accounts at any time")


            }
            Spacer(Modifier.height(12.dp))
            Title("Changes to Terms")
            Spacer(Modifier.height(12.dp))
            PolicyRow("We may update these terms periodically. Any significant changes will be communicated to users.")
            Spacer(Modifier.height(12.dp))
            Title("Changes to this Policy")
            Spacer(Modifier.height(12.dp))
            PolicyRow("We may update this privacy policy periodically. Any significant changes will be communicated to users.\n")
            Title("Contact Us")
            SubHeadingSub("If you have questions or concerns about these terms, please reach out to us at support@VidDown.com.")


        }
    }
}