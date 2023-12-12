package com.development.gocipes.core.domain.model.food

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val listFood: List<Food> = emptyList()
) : Parcelable
