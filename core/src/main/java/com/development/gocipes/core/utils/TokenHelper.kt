package com.development.gocipes.core.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

object TokenHelper {

    suspend fun generateToken(token: Flow<String?>) = "Bearer ${token.first()}"
}