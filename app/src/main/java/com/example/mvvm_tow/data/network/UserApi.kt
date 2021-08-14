package com.example.mvvm_tow.data.network

import com.example.mvvm_tow.data.responses.LoginResponse
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    suspend fun getUser(): LoginResponse

}