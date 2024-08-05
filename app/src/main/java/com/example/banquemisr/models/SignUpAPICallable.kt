package com.example.banquemisr.models



import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpAPICallable {

    @POST("register")
    fun signUp(@Body request: SignUpRequest): Call<SignUpResponse>

    @POST("/api/auth/register")
    fun signUp(@Body request: SignUpRequest): Response<Unit>

}