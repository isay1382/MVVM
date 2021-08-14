package com.example.mvvm_tow.ui.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.mvvm_tow.databinding.FragmentLoginBinding
import com.example.mvvm_tow.data.network.AuthApi
import com.example.mvvm_tow.data.network.Resource
import com.example.mvvm_tow.data.repository.AuthRepository
import com.example.mvvm_tow.ui.base.BaseFragment
import com.example.mvvm_tow.ui.enable
import com.example.mvvm_tow.ui.home.HomeActivity
import com.example.mvvm_tow.ui.startNewActivity
import com.example.mvvm_tow.ui.visible
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment<AuthViewModel,FragmentLoginBinding,AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.progressbar.visible(false)
        binding.buttonLogin.enable(false)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressbar.visible(false)
            when(it){
                is Resource.Success -> {
                        viewModel.saveAuthToken(it.value.user.access_token!!)
                        requireActivity().startNewActivity(HomeActivity::class.java)
                }
                is Resource.Failure-> {
                    Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_SHORT).show()
                }

            }
        })


        binding.editTextTextPassword.addTextChangedListener {
            val email =binding.editTextTextEmailAddress.text.toString().trim()
            binding.buttonLogin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }



        binding.buttonLogin.setOnClickListener {
            val email=binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()
            //@todo add input validations
            binding.progressbar.visible(true)
            viewModel.login(email, password)

        }

    }


    override fun getViewModel()= AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater,container,false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java),userPreferences)


}