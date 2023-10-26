@file:OptIn(ExperimentalFoundationApi::class)

package com.example.kotlincomposenewapp.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlincomposenewapp.ui.components.Loader
import com.example.kotlincomposenewapp.ui.components.NewsList
import com.example.kotlincomposenewapp.ui.components.NewsRowComponent
import com.example.kotlincomposenewapp.ui.viewModel.NewsViewModel
import com.example.utilities.StateResource

const val TAG = "HomeScreen"
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {


    val newsResp = newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ){
        100
    }
    VerticalPager(state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
        ){ page: Int ->

        when (newsResp.value) {
            is StateResource.Loading -> {
                Log.d(TAG, "Inside Loading")
                Loader()
            }
            is StateResource.Success-> {
                val response = (newsResp.value as StateResource.Success).data
                Log.d(TAG, "Inside Success ${response.status} = ${response.totalResults}")
                if(response.articles.isNotEmpty()){
                    NewsRowComponent(page, response.articles.get(page))
                }
            }
            is StateResource.Error -> {
                val error = (newsResp.value as StateResource.Error)
                Log.d(TAG, "Inside Error $error")

            }
        }

        // provide pageCount
    }
}



@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}