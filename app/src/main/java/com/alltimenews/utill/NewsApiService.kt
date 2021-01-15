package com.alltimenews.utill

import com.alltimenews.mainActivity.ui.home.model.NewsModel
import retrofit2.http.*

interface NewsApiService {

    @Headers(
        "Content-Type:application/x-www-form-urlencoded"
    )
    @GET("top-headlines")
    suspend fun getUsers(@Query("country") country: String?,
                         @Query("language") language: String?,
                         @Query("category") category: String?,
                         @Query("apiKey") apiKey: String?): NewsModel
}
