package com.example.mvvm_tow.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_tow.data.network.Resource
import com.example.mvvm_tow.data.repository.UserRepository
import com.example.mvvm_tow.data.responses.LoginResponse
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repository: UserRepository
    ):ViewModel(){

        private val _user : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
        val user : LiveData<Resource<LoginResponse>>
        get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = Resource.Loading
        _user.value = repository.getUser()
    }

    }

