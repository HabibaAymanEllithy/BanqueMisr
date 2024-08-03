package com.example.banquemisr.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel:ViewModel() {

    private val repository = Repository()

    private val _signUpSuccess = MutableStateFlow<Boolean?>(null)
    val signUpSuccess= _signUpSuccess.asStateFlow()

    fun signUp( fullName:String,
                email:String,
                phoneNumber:String,
                username:String,
                password:String,
                confirmPassword:String,
                gender:String,
                country:String,
                birthDate:String) {
        viewModelScope.launch {
            val signUpRequest = SignUpRequest(fullName, email, phoneNumber,username,password,confirmPassword,gender,country,birthDate)
            val result = repository.signUp(signUpRequest)
            _signUpSuccess.value = result
        }
    }


}
class Repository {
    suspend fun signUp(signUpRequest: SignUpRequest): Boolean {
        val response = SignUpAPIService.callable.signUp(signUpRequest).execute()
        return response.isSuccessful
    }
}