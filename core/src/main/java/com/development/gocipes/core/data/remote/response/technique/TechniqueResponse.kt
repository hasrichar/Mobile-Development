package com.development.gocipes.core.data.remote.response.technique

data class TechniqueResponse(
	val msg: String? = null,
	val code: Int? = null,
	val data: List<TechniqueItem> = emptyList(),
	val status: String? = null
)