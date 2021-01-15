package com.alltimenews.utill

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object  NetworkModule : Constant
{

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: NewsApiService = getRetrofit().create(NewsApiService::class.java)
}