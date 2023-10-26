package com.example.kotlincomposenewapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.kotlincomposenewapp.ui.navigation.AppNavigationGraph
import com.example.kotlincomposenewapp.ui.theme.KotlinComposeNewAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            KotlinComposeNewAppTheme {
                Surface( // Entire screen
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                KotlinComposeNewAppEntryPoint()
                }
            }
        }
    }
}

@Composable

fun KotlinComposeNewAppEntryPoint(){
    AppNavigationGraph()
}