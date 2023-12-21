package com.development.gocipes.core.domain.model.food

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cook(
    val id: Int,
    val imageUrl: String,
    val description: String,
    val minutes: Int,
): Parcelable