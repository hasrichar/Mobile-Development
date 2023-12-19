package com.development.gocipes.core.data.local.datastore

import kotlinx.coroutines.flow.Flow

interface UserPreferences {

    fun isLoggedIn(): Flow<Boolean>

    fun getToken(): Flow<String?>

    suspend fun saveLogInStatus(isLogin: Boolean)

    suspend fun saveToken(token: String)

    suspend fun deleteToken()
}