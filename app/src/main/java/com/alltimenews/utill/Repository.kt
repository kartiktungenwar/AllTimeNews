package com.alltimenews.utill

import android.content.Context
import javax.inject.Inject




class Repository {

    var apiService: NewsApiService? = null

    @Inject
    fun Repository(apiService: NewsApiService?) {
        this.apiService = apiService
    }

}