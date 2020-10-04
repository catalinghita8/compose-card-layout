package com.codingtroops.composeapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.align
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mockUserProfile = UserProfile.getMockProfileUser()
        setContent { MainActivityComposable(mockUserProfile) }
    }
}

@Composable
fun MainActivityComposable(userProfile: UserProfile) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Helper.getGreenColor()
    )
    { ProfileCardComposable(userProfile) }
}

@Composable
fun ProfileCardComposable(userProfile: UserProfile) {
    val onlineStatus = remember { mutableStateOf(userProfile.isOnline) }
    Row(
        Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(4.dp))
            .background(color = Helper.getWhiteColor())
            .clickable(onClick = { onlineStatus.value = onlineStatus.value.not() })
            .padding(16.dp)
    ) {
        ProfilePictureComposable(onlineStatus, userProfile.profilePictureDrawableId)
        ProfileContentComposable(onlineStatus, userProfile.name, userProfile.lastActivityMinutes)
    }
}

@Composable
fun ProfilePictureComposable(
    onlineStatus: MutableState<Boolean>,
    pictureDrawableId: Int
) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            2.dp,
            color = if (onlineStatus.value)
                Helper.getGreenColor()
            else
                Helper.getRedColor()
        ),
        modifier = Modifier.preferredSize(48.dp),
        elevation = 4.dp
    ) {
        Image(
            imageResource(id = pictureDrawableId),
            contentScale = ContentScale.Crop,
            modifier = Modifier.preferredSize(48.dp)
        )
    }
}

@Composable
fun ProfileContentComposable(
    onlineStatus: MutableState<Boolean>,
    name: String,
    lastActivityMinutes: Int
) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp)
            .align(Alignment.CenterVertically)
    ) {
        Text(name, fontWeight = FontWeight.Bold)
        Text(
            text = if (onlineStatus.value)
                "Active now"
            else
                "$lastActivityMinutes mins ago",
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun UserProfileCardPreview() {
    val mockUserProfile = UserProfile.getMockProfileUser()
    MainActivityComposable(mockUserProfile)
}