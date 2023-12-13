package com.development.gocipes.core.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: LoginItem? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class LoginItem(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("token")
	val token: Token? = null
)
