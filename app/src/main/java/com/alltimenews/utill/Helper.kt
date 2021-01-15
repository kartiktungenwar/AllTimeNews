package com.alltimenews.utill

class Helper (private val apiService: NewsApiService,private  var country: String?,private  var language: String?,private  var category: String?,private  var apiKey: String? ){

    suspend fun getUsers() = apiService.getUsers(country,language,category,apiKey)
}