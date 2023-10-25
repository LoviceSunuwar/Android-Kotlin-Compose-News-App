package com.example.kotlincomposenewapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincomposenewapp.data.entity.NewsResponse
import com.example.kotlincomposenewapp.ui.repository.NewsRepo
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
// Injecting the Hilt viewModel
class NewsViewModel @Inject constructor(
    private val newsRepo: NewsRepo
) : ViewModel() {

    private val _news : MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news : StateFlow<ResourceState<NewsResponse>> = _news // Stateflow makes the value static
    fun getNews(country: String){
        // Background thread for the api calll
        viewModelScope.launch (Dispatchers.IO  ){
            newsRepo.getNewsHeadline(country)
                .collectLatest { newsResponse ->
                    _news.value = newsResponse

                }
        }
    }
    init {
        Log.d(TAG, "Init block of NewsViewModel")
    }

    fun doSomething(){
        println("do something")
    }

    companion object{
        const val TAG = "NewsViewModel"
    }


}