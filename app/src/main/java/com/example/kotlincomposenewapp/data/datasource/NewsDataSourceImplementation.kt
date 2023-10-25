package com.example.kotlincomposenewapp.data.datasource

import com.example.kotlincomposenewapp.data.api.ApiService
import com.example.kotlincomposenewapp.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImplementation @Inject constructor(private val apiService: ApiService) : NewsDataSource {

    override suspend fun getNewsHeadLine(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadLine(country)
    }
}