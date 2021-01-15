package com.alltimenews.util

import com.alltimenews.utill.Helper

class Repository(private val apiHelper: Helper) {

    suspend fun getUsers() = apiHelper.getUsers()

}