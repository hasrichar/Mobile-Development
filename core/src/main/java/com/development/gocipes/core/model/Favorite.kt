package com.development.gocipes.core.model

data class Favorite(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val category: List<Category>,
)
