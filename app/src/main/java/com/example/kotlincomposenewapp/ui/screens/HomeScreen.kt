package com.example.kotlincomposenewapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlincomposenewapp.ui.components.Loader
import com.example.kotlincomposenewapp.ui.components.NewsList
import com.example.kotlincomposenewapp.ui.viewModel.NewsViewModel
import com.example.utilities.StateResource

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {


    val newsResp = newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (newsResp.value) {
            is StateResource.Loading -> {
                Log.d(TAG, "Inside Loading")
                Loader()
            }
            is StateResource.Success-> {
                val response = (newsResp.value as StateResource.Success).data
                Log.d(TAG, "Inside Success ${response.status} = ${response.totalResults}")
                NewsList(response)
            }
            is StateResource.Error -> {
                val error = (newsResp.value as StateResource.Error)
                Log.d(TAG, "Inside Error $error")

            }
        }
    }
}



@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}