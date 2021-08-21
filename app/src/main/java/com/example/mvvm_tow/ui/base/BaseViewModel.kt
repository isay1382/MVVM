package com.example.mvvm_tow.ui.base

import androidx.lifecycle.ViewModel
import com.example.mvvm_tow.data.network.UserApi
import com.example.mvvm_tow.data.repository.BaseRepository

abstract class BaseViewModel (
    private val repository: BaseRepository
):ViewModel(){

    suspend fun logout(api: UserApi) = repository.logout(api)

}

