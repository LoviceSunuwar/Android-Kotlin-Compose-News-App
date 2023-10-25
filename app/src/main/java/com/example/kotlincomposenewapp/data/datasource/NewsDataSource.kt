package com.example.kotlincomposenewapp.data.datasource
import com.example.kotlincomposenewapp.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsDataSource {
    @GET("v2/top-headlines")
    fun getNewsHeadLine(country : String) : Response<NewsResponse>


}

//GET https://newsapi.org/v2/everything?q=Apple&from=2023-10-25&sortBy=popularity&apiKey=API_KEY
//e8f59402e82d4590b2c73eda2f4644a2

