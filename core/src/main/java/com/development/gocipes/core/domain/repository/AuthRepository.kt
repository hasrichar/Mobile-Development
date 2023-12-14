package com.development.gocipes.core.domain.repository

import com.development.gocipes.core.data.remote.response.ForgotPasswordResponse
import com.development.gocipes.core.data.remote.response.GetUserResponse
import com.development.gocipes.core.data.remote.response.LoginItem
import com.development.gocipes.core.data.remote.response.RegisterItem
import com.development.gocipes.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Flow<Result<RegisterItem>>

    fun login(email: String, password: String): Flow<Result<LoginItem>>

    fun forgotPassword(
        email: String
    ): Flow<Result<ForgotPasswordResponse>>

    fun getUserInfo(): Flow<Result<GetUserResponse>>
}