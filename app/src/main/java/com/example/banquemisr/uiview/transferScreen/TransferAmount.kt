package com.example.banquemisr.uiview.transferScreen

import java.net.URL

data class TransferAmount(
    val amountUSD: String,
    val usdURL: URL,
    val amountEGP: String,
    val egpURL: URL,
    val recipientName: String,
    val recipientAccount: String,
    val currency: String = "USD" // Default currency
)
