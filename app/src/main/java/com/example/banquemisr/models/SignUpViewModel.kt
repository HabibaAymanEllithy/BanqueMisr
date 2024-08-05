package com.example.banquemisr.models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val repository = Repository()

    private val _signUpSuccess = MutableStateFlow<Boolean?>(false)
    val signUpSuccess = _signUpSuccess.asStateFlow()

     fun signUp(
        fullName: String,
        email: String,
        phoneNumber: String,
        username: String,
        password: String,
        confirmPassword: String,
        gender: String,
        country: String,
        birthDate: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val signUpRequest = SignUpRequest(
                fullName,
                email,
                phoneNumber,
                username,
                password,
                confirmPassword,
                gender,
                country,
                birthDate
            )
            val result = repository.signUp(signUpRequest)
            _signUpSuccess.value = result
        }
    }


}

class Repository {
   fun signUp(signUpRequest: SignUpRequest): Boolean {
        try {
            val response = SignUpAPIService.callable.signUp(signUpRequest)
            return response.isSuccessful
        } catch (e: Exception) {
            Log.d("trace", "error:${e.message}")
            return false
        }
    }
}
