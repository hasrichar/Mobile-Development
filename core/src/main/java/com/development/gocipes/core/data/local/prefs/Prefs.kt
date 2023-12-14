package com.development.gocipes.core.data.local.prefs

import com.development.gocipes.core.utils.Constants.EMAIL
import com.development.gocipes.core.utils.Constants.FIRST_NAME
import com.development.gocipes.core.utils.Constants.PASSWORD
import com.development.gocipes.core.utils.Constants.TOKEN_KEY
import com.pixplicity.easyprefs.library.Prefs

object Prefs {

    var email: String
        get() = Prefs.getString(EMAIL, "")
        set(value) = Prefs.putString(EMAIL, value)

    var password: String
        get() = Prefs.getString(PASSWORD, "")
        set(value) = Prefs.putString(PASSWORD, value)

    var userToken: String
        get() = Prefs.getString(TOKEN_KEY, "")
        set(value) = Prefs.putString(TOKEN_KEY, value)

    var firstName: String
        get() = Prefs.getString(FIRST_NAME,"")
        set(value) = Prefs.putString(FIRST_NAME,value)
}