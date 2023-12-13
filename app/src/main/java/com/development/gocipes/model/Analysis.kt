package com.development.gocipes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Analysis(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val energi: Int,
    val protein: Double,
    val lemak: Double,
    val karbo: Double,
):Parcelable
