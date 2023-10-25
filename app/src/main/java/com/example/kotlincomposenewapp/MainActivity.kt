package com.example.kotlincomposenewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlincomposenewapp.ui.navigation.AppNavigationGraph
import com.example.kotlincomposenewapp.ui.theme.KotlinComposeNewAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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