package com.development.gocipes.core.data.remote.retrofit

import com.development.gocipes.core.data.local.prefs.Prefs
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    private val token = "Bearer ${Prefs.userToken}"
    override fun intercept(chain: Interceptor.Chain): Response {

        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", token)
        return chain.proceed(requestBuilder.build())
    }
}