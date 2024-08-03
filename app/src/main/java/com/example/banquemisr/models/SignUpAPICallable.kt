package com.example.banquemisr.models



import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpAPICallable {

    @POST("register")
    fun signUp(@Body request: SignUpRequest): Call<SignUpResponse>
}