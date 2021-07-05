package com.example.mvvm_tow.network

import com.example.mvvm_tow.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
            @Field("email") email : String,
            @Field("password") password : String
    ) : LoginResponse

}