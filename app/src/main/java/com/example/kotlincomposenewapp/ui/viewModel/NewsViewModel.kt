package com.example.kotlincomposenewapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincomposenewapp.data.AppConstants
import com.example.kotlincomposenewapp.data.entity.NewsResponse
import com.example.kotlincomposenewapp.ui.repository.NewsRepo
import com.example.utilities.StateResource
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

    private val _news: MutableStateFlow<StateResource<NewsResponse>> =
        MutableStateFlow(StateResource.Loading())


    val news: StateFlow<StateResource<NewsResponse>> = _news // Stateflow makes the value static
    init {
        getNews(AppConstants.COUNTRY)
    }
    fun getNews(country: String){
        // Background thread for the api call
        viewModelScope.launch (Dispatchers.IO){
            newsRepo.getNewsHeadline(country)
                .collectLatest { newsResponse ->
                    _news.value = newsResponse
                }
        }
    }
}