package com.alltimenews.utill

interface Constant {

    val BASE_URL : String
    get() = "http://newsapi.org/v2/"

    val API_KEY : String
        get() = "952da71b07954070b1fd98d174b01d11"

    val COUNTRY_ID : String
        get() = "country_id"

    val LANGUAGE : String
        get() = "language_id"

    val FIRST_TIME : String
        get() = "first_time"
}