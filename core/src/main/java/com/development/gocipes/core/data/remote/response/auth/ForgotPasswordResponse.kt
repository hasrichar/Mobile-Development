package com.development.gocipes.core.data.remote.response.auth

import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse(

	@field:SerializedName("msg")
	val msg: String,

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("status")
	val status: String
)
