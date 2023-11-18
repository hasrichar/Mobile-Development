package com.development.gocipes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Information(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
): Parcelable