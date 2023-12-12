package com.development.gocipes.core.data.network

import com.development.gocipes.core.data.network.retrofit.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun register(firstName: String, lastName: String, username: String, password: String) = apiService.register(firstName, lastName, username, password)
}