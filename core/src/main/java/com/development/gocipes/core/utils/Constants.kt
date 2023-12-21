package com.development.gocipes.core.utils

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {

    const val EMAIL = "email"
    const val PASSWORD = "password"
    const val FIRST_NAME = "first_name"

    const val USER_PREFERENCES = "presence_preferences"
    val TOKEN_KEY = stringPreferencesKey("mToken")
    val LOGIN_STATUS_KEY = booleanPreferencesKey("login")
}
