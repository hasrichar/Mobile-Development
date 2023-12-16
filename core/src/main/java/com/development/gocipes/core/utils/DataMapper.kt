package com.development.gocipes.core.utils

import com.development.gocipes.core.data.remote.response.technique.TechniqueItem
import com.development.gocipes.core.domain.model.technique.Technique

fun TechniqueItem.toDomain() = Technique(
    id = id,
    title = title,
    description = description,
    cover = cover,
    source = sumber,
    videoUrl = url
)