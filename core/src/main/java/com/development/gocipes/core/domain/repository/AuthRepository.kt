package com.development.gocipes.core.domain.repository

import com.development.gocipes.core.data.network.response.RegisterItem
import com.development.gocipes.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Flow<Result<RegisterItem>>
}