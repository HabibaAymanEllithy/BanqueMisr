package com.example.banquemisr.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface BalanceAPICallable {
    @GET("balance")
    fun getBalance(@Header("Authorization") token: Int): CurrentBalance
}