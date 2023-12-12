package com.development.gocipes.core.domain.model.food

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredient(
    val id: Int,
    val description: String,
): Parcelable
