package com.example.banquemisr.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SignUpAPIService {
    private val retrofit= Retrofit.
    Builder()
        .baseUrl("https://speedo-transfer-437e318f5416.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable: SignUpAPICallable by lazy{
        retrofit.create(SignUpAPICallable::class.java)
    }
}