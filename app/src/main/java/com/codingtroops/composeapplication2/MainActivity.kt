package com.codingtroops.composeapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.ui.tooling.preview.Preview
import com.codingtroops.composeapplication2.ui.ComposeApplication2Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainActivityComposable() }
    }
}

@Composable
fun MainActivityComposable() {  }

@Preview
@Composable
fun UserProfileCardPreview() {
    MainActivityComposable()
}