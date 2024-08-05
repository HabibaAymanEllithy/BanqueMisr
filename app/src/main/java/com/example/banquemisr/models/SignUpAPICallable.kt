package com.example.banquemisr.models



import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpAPICallable {

<<<<<<< HEAD
    @POST("register")
    fun signUp(@Body request: SignUpRequest): Call<SignUpResponse>
=======
    @POST("/api/auth/register")
    fun signUp(@Body request: SignUpRequest): Response<Unit>

>>>>>>> 6f39208864dcc7258d4cdc3adf7e0e0f364b1419
}