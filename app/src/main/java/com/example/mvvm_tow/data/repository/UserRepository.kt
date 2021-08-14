package com.example.mvvm_tow.data.repository

import com.example.mvvm_tow.data.UserPreferences
import com.example.mvvm_tow.data.network.AuthApi
import com.example.mvvm_tow.data.network.UserApi

class UserRepository(
    private val api : UserApi
) : BaseRepository(){

    suspend fun getUser() = safeApiCall {
        api.getUser()
    }

}