package com.development.gocipes.core.domain.model.food

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val id: Int,
    val name: String,
    val description: String,
    val minutes: String,
    val imageUrl: String,
    val category: String,
    val fat: Int,
    val carbohydrates: Int,
    val protein: Int,
    val ingredients: List<Ingredient>,
    val step: List<Cook>,
): Parcelable