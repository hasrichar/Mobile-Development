package com.development.gocipes.core.domain.repository

import com.development.gocipes.core.data.remote.response.auth.ForgotPasswordResponse
import com.development.gocipes.core.data.remote.response.auth.LoginItem
import com.development.gocipes.core.data.remote.response.auth.RegisterItem
import com.development.gocipes.core.data.remote.response.auth.UserResult
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

    fun getUserInfo(): Flow<Result<UserResult>>
}