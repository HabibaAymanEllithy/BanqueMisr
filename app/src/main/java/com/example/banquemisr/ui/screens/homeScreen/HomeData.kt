package com.example.banquemisr.ui.screens.homeScreen

import com.example.banquemisr.screens.navigation.Screen

data class HomeData (
    var currentBalance: Double,
    var balanceTransfer: Double,
    var userName: String,
    val recentTransactions: List<Screen.Transaction>
)
