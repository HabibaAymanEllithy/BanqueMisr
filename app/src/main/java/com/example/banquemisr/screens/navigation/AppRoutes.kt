package com.example.banquemisr.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.banquemisr.screens.signIn.SignInScreen
import com.example.banquemisr.screens.signUp.SignUpScreen
import com.example.banquemisr.screens.signUp.SignUpScreen2
import com.example.banquemisr.screens.splash.SplashScreen
import com.example.banquemisr.ui.screens.homeScreen.HomeScreen
import com.example.banquemisr.ui.screens.transactionScreen.SuccessfulTransactionScreen
import com.example.banquemisr.ui.screens.transactionScreen.TransActionScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferAmountScreen

object AppRoutes {
    const val SIGN_UP_ROUTE = "signUp"
    const val SIGN_UP_COMPLETE_ROUTE = "SignUpComplete"
    const val SIGNIN_ROUTE = "signIn"
    const val SPLASH_ROUTE = "splash"
    const val HOME_ROUTE = "home"
    const val TRANSFER_ROUTE = "transfer"
    const val TRANSACTION_ROUTE = "transaction"
    const val CARD_ROUTE = "card"
    const val MORE_ROUTE = "more"
    const val SUCCESSFUL_TRANSACTION_ROUTE = "successfulTransaction"
   // const val FIELD_TRANSACTION_ROUTE = "fieldTransaction"

    @Composable

    fun AppNavigation(modifier: Modifier = Modifier) {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = SPLASH_ROUTE,
            modifier = modifier
        ) {
            composable(route = SIGN_UP_ROUTE) {
                SignUpScreen(navController)
            }

            composable(
                route = "$SIGN_UP_COMPLETE_ROUTE/{fullName}/{email}/{password}",
                arguments = listOf(
                    navArgument("fullName") { type = NavType.StringType },
                    navArgument("email") { type = NavType.StringType },
                    navArgument("password") { type = NavType.StringType }
                )
            ) {
                val fullName = it.arguments?.getString("fullName") ?: ""
                val email = it.arguments?.getString("email") ?: ""
                val password = it.arguments?.getString("password") ?: ""

                SignUpScreen2(navController,fullName, email, password)
            }

            composable(route = SIGNIN_ROUTE) {
                SignInScreen(navController)
            }
            composable(route = SPLASH_ROUTE) {
                SplashScreen(navController)
            }
            composable(route = HOME_ROUTE) {
                HomeScreen()
            }
            composable(route = TRANSFER_ROUTE) {
                TransferAmountScreen(navController)
            }
            composable(route = TRANSACTION_ROUTE) {
                TransActionScreen(navController = navController)
            }
            composable(route = CARD_ROUTE) {
                // CardsScreen(navController = navController)
            }
            composable(route = MORE_ROUTE) {
                // MenueScreen(navController = navController)
            }
            composable(route = SUCCESSFUL_TRANSACTION_ROUTE) {
                SuccessfulTransactionScreen(navController = navController)
            }
//            composable(route = FIELD_TRANSACTION_ROUTE) {
//                // FieldTransactionScreen(navController = navController)
//
//            }
        }
    }
}
