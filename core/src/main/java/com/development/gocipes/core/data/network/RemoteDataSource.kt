package com.development.gocipes.core.data.network

import com.development.gocipes.core.data.network.retrofit.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun register(firstName: String, lastName: String, email: String, password: String) = apiService.register(firstName, lastName, email, password)

    suspend fun login(email: String, password: String) = apiService.login(email, password)

    suspend fun forgotPassword(email: String) = apiService.forgotPassword(email)
}