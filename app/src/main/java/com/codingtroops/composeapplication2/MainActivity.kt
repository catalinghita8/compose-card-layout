package com.codingtroops.composeapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.align
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
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
        setContent { MainActivityComposable() }
    }
}

@Composable
fun MainActivityComposable() {
    Surface(
            modifier = Modifier.fillMaxSize(),
            color = Helper.getGreenColor()
    )
    { ProfileCardComposable() }
}

@Composable
fun ProfileCardComposable() {
    Row(
            Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(4.dp))
                    .background(color = Helper.getWhiteColor())
                    .padding(16.dp),
    ) {
        ProfilePictureComposable()
        ProfileContentComposable()
    }
}

@Composable
fun ProfilePictureComposable() {
    Card(
            shape = CircleShape,
            border = BorderStroke(2.dp, color = Helper.getGreenColor()),
            modifier = Modifier.preferredSize(48.dp),
            elevation = 4.dp
    ) {
        Image(
                imageResource(id = R.drawable.profile_pic),
                contentScale = ContentScale.Crop,
                modifier = Modifier.preferredSize(48.dp)
        )
    }
}

@Composable
fun ProfileContentComposable() {
    Column(
            modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
    ) {
        Text("Catalin Ghita", fontWeight = FontWeight.Bold)
        Text(
                text = "Active now",
                style = MaterialTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun UserProfileCardPreview() {
    MainActivityComposable()
}