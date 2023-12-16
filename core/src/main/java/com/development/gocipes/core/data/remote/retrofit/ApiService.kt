package com.development.gocipes.core.data.remote.retrofit

import com.development.gocipes.core.data.remote.response.auth.ForgotPasswordResponse
import com.development.gocipes.core.data.remote.response.auth.GetUserResponse
import com.development.gocipes.core.data.remote.response.auth.LoginResponse
import com.development.gocipes.core.data.remote.response.auth.RegisterResponse
import com.development.gocipes.core.data.remote.response.technique.TechniqueResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @FormUrlEncoded
    @POST("auth/forgot-password")
    suspend fun forgotPassword(
        @Field("email") email: String,
    ): ForgotPasswordResponse

    @GET("user/get-info")
    suspend fun getUserInfo(): GetUserResponse

    @GET("data/teknik")
    suspend fun getAllTechnique(): TechniqueResponse
}