package com.alltimenews.mainActivity.ui.home.model

import com.google.gson.annotations.SerializedName


data class NewsModel(
	@SerializedName("status") var status : String,
	@SerializedName("totalResults") var totalResults : Int,
	@SerializedName("articles") var articles : List<Articles>
)