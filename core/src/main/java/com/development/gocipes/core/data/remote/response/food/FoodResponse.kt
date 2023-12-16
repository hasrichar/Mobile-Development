package com.development.gocipes.core.data.remote.response.food

data class FoodResponse(
	val msg: String? = null,
	val code: Int? = null,
	val data: List<FoodItem> = emptyList(),
	val status: String? = null
)