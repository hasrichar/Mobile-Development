package com.development.gocipes.core.data.local

import com.development.gocipes.core.data.local.datastore.UserPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val userPreferences: UserPreferences,
) {
    fun isLoggedIn() = userPreferences.isLoggedIn()

    fun getToken() = userPreferences.getToken()

    suspend fun saveLoginStatus(isLogin: Boolean) = userPreferences.saveLogInStatus(isLogin)

    suspend fun saveToken(token: String) = userPreferences.saveToken(token)

    suspend fun deleteToken() = userPreferences.deleteToken()
}