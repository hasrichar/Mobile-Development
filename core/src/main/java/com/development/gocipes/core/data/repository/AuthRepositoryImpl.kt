package com.development.gocipes.core.data.repository

import com.development.gocipes.core.data.remote.RemoteDataSource
import com.development.gocipes.core.domain.repository.AuthRepository
import com.development.gocipes.core.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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
            if (result != null) emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    override fun login(email: String, password: String) = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.login(email, password)
            val result = response.data
            if (result != null) emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    override fun forgotPassword(
        email: String
    ) = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.forgotPassword(email)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    override fun getUserInfo() = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.getUserInfo()
            val result = response.data
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}