package com.development.gocipes.core.domain.model.favorite

import com.development.gocipes.core.domain.model.food.Category

data class Favorite(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val category: List<Category>,
)
