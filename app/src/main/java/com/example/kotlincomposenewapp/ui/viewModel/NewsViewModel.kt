package com.example.kotlincomposenewapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
// Injecting the Hilt viewModel
class NewsViewModel @Inject constructor() : ViewModel() {
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