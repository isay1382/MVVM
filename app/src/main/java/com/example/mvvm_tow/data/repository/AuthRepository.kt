package com.example.mvvm_tow.data.repository

import com.example.mvvm_tow.data.UserPreferences
import com.example.mvvm_tow.data.network.AuthApi

class AuthRepository(
    private val api : AuthApi,
    private val preferences : UserPreferences
) : BaseRepository(){

    suspend fun login(
        email : String,
        password: String
    )=safeApiCall {
        api.login(email,password)
    }


    suspend fun saveAuthToken(token : String){
        preferences.saveAuthToken(token)
    }

}