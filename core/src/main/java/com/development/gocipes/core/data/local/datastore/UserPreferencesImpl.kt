package com.development.gocipes.core.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.development.gocipes.core.utils.Constants.LOGIN_STATUS_KEY
import com.development.gocipes.core.utils.Constants.TOKEN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : UserPreferences {
    override fun isLoggedIn() =
        dataStore.data.map {
            it[LOGIN_STATUS_KEY] ?: false
        }

    override fun getToken(): Flow<String?> =
        dataStore.data.map {
            it[TOKEN_KEY]
        }

    override suspend fun saveLogInStatus(isLogin: Boolean) {
        dataStore.edit {
            it[LOGIN_STATUS_KEY] = isLogin
        }
    }

    override suspend fun saveToken(token: String) {
        dataStore.edit {
            it[TOKEN_KEY] = token
        }
    }

    override suspend fun deleteToken() {
        dataStore.edit {
            it.remove(TOKEN_KEY)
        }
    }
}