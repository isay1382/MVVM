package com.example.mvvm_tow.ui.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mvvm_tow.R
import com.example.mvvm_tow.databinding.FragmentLoginBinding
import com.example.mvvm_tow.network.AuthApi
import com.example.mvvm_tow.repository.AuthRepository
import com.example.mvvm_tow.ui.base.BaseFragment


class LoginFragment : BaseFragment<AuthViewModel,FragmentLoginBinding,AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun getViewModel()= AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater,container,false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))


}