package com.development.gocipes.core.data.network.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    private val token = "Bearer TODO"
    override fun intercept(chain: Interceptor.Chain): Response {

        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", token)
        return chain.proceed(requestBuilder.build())
    }
}