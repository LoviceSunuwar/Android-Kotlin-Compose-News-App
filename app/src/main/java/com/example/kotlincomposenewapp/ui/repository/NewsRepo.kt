package com.example.kotlincomposenewapp.ui.repository

import com.example.kotlincomposenewapp.data.datasource.NewsDataSource
import com.example.kotlincomposenewapp.data.entity.NewsResponse
import com.example.utilities.StateResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepo @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
//    suspend fun getNewsHeadline(country:String) : Response<NewsResponse>{
//        return newsDataSource.getNewsHeadLine(country)
//    }

//    suspend fun getNewsHeadline(country:String) : Flow<ResourceState<NewsResponse>> {
//        return flow{
//            emit(ResourceState.Loading())
//            val response = newsDataSource.getNewsHeadLine(country)
//
//            if(response.isSuccessful && response.body() != null ){
//                emit(ResourceState.Success(response.body()!!))
//            } else {
//                emit(ResourceState.Error("Error Fetching The News Data"))
//            }
//        }.catch { e->
//            emit(ResourceState.Error(e?.localizedMessage ?: "Some error in flow"))
//        }
//
//    }

    suspend fun getNewsHeadline(country: String) : Flow<StateResource<NewsResponse>> {
        return flow {
            emit(StateResource.Loading())
            val response = newsDataSource.getNewsHeadLine(country)

            if(response.isSuccessful && response.body() != null ){
                emit(StateResource.Success(response.body()!!))
            } else {
                emit(StateResource.Error("Error Fetching The News Data"))
        }
    }.catch { e->
            emit(StateResource.Error(e?.localizedMessage ?: "Some error in flow"))
        }
    }
}