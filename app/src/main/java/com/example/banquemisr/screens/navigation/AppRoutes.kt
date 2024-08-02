package com.example.banquemisr.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.banquemisr.screens.signIn.SignInScreen
import com.example.banquemisr.screens.signUp.SignUpScreen
import com.example.banquemisr.screens.signUp.SignUpScreen2
import com.example.banquemisr.screens.splash.SplashScreen

object AppRoutes {
    const val SIGN_UP_ROUTE = "signUp"
    const val SIGN_UP_COMPLETE_ROUTE = "SignUpComplete"
    const val SIGNIN_ROUTE = "signIn"
    const val SPLASH_ROUTE = "splash"

    @Composable

    fun AppNavHost(modifier: Modifier = Modifier) {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = SPLASH_ROUTE,
            modifier = modifier
        ) {
            composable(route = SIGN_UP_ROUTE) {
                SignUpScreen(navController)
            }
            composable(route = SIGN_UP_COMPLETE_ROUTE) {
                SignUpScreen2(navController)
            }

            composable(route = SIGNIN_ROUTE) {
                SignInScreen(navController)
            }
            composable(route = SPLASH_ROUTE) {
                SplashScreen(navController)
            }
        }
    }
}
