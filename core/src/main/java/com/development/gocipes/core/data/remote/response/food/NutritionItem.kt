package com.development.gocipes.core.data.remote.response.food

import com.google.gson.annotations.SerializedName


data class NutritionItem(

	@field:SerializedName("karbohidrat")
	val karbohidrat: Int? = null,

	@field:SerializedName("protein")
	val protein: Int? = null,

	@field:SerializedName("lemak")
	val lemak: Int? = null
)
