package com.development.gocipes.core.data.repository

import com.development.gocipes.core.data.network.RemoteDataSource
import com.development.gocipes.core.domain.repository.AuthRepository
import com.development.gocipes.core.utils.Result
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : AuthRepository {
    override fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ) = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.register(firstName, lastName, email, password)
            val result = response.data
            if (result != null) {
                emit(Result.Success(result))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }
}