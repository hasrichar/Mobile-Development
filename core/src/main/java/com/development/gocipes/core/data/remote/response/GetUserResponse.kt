package com.development.gocipes.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetUserResponse(

	@field:SerializedName("msg")
	val msg: String,

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("status")
	val status: String
)

data class Data(

	@field:SerializedName("role")
	val role: String,

	@field:SerializedName("isVerified")
	val isVerified: Boolean,

	@field:SerializedName("last_name")
	val lastName: String,

	@field:SerializedName("photo")
	val photo: Any,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("email")
	val email: String
)
