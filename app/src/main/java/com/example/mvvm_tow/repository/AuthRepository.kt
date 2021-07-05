package com.example.mvvm_tow.repository

import com.example.mvvm_tow.network.AuthApi

class AuthRepository(
    private val api : AuthApi
) : BaseRepository(){

    suspend fun login(
        email : String,
        password: String
    )=safeApiCall {
        api.login(email,password)
    }

}