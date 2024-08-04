package com.example.banquemisr.screens.navigation

import HomeScreen
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
import com.example.banquemisr.ui.screens.notification.NotificationScreen
import com.example.banquemisr.ui.screens.transactionScreen.SuccessfulTransactionScreen
import com.example.banquemisr.ui.screens.transactionScreen.TransActionScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferAmountScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferConfirmationScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferPaymentScreen

object AppRoutes {
    const val SIGN_UP_ROUTE = "signUp"
    const val SIGN_UP_COMPLETE_ROUTE = "SignUpComplete"
    const val SIGNIN_ROUTE = "signIn"
    const val SPLASH_ROUTE = "splash"
    const val HOME_ROUTE = "home"
    const val TRANSFERAMOUNT_ROUTE = "transferAmount"
    const val TRANSFERCONFIRMATION_ROUTE = "transferConfirmation"
    const val TRASFERPAYMENT_ROUTE = "transferPayment"
    const val TRANSACTION_ROUTE = "transaction"
    const val CARD_ROUTE = "card"
    const val MORE_ROUTE = "more"
    const val SUCCESSFUL_TRANSACTION_ROUTE = "successfulTransaction"
    const val NOTIFICATION_ROUTE = "notification"
    const val SUCCESFUL_TRANSACTION_ROUTE = "successfulTransaction"


    @Composable

    fun AppNavigation(modifier: Modifier = Modifier) {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = SPLASH_ROUTE,
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
                HomeScreen(navController)
            }
            composable(route = TRANSFERAMOUNT_ROUTE) {
                TransferAmountScreen(navController)
            }

            composable(route = "$TRANSFERCONFIRMATION_ROUTE  /{amount}/{recipientName}/{recipientAccount}"
            , arguments =
                listOf(navArgument("amount"){type = NavType.FloatType}
                        , navArgument("recipientName"){type=NavType.StringType}
                        , navArgument("recipientAccount"){type=NavType.StringType})
            ) {
                val amount = it.arguments?.getDouble("amount") ?: ""
                val recipientName = it.arguments?.getString("recipientName") ?: ""
                val recipientAccount = it.arguments?.getString("recipientAccount") ?: ""

                 TransferConfirmationScreen(navController, amount =amount , recipientName =recipientName, recipientAccount =recipientAccount)
            }

            composable(route = "$TRASFERPAYMENT_ROUTE  /{amount}/{recipientName}/{recipientAccount}"
            , arguments = listOf(navArgument("amount"){type = NavType.FloatType}
                    , navArgument("recipientName"){type=NavType.StringType}
            , navArgument("recipientAccount"){type=NavType.StringType})) {

                val amount = it.arguments?.getDouble("amount") ?: ""
                val recipientName = it.arguments?.getString("recipientName") ?: ""
                val recipientAccount = it.arguments?.getString("recipientAccount") ?: ""

                 TransferPaymentScreen(navController = navController)
            }
            composable(route = TRANSACTION_ROUTE) {
                TransActionScreen(navController = navController)
            }
            composable(route = NOTIFICATION_ROUTE) {
                 NotificationScreen(navController = navController)
            }
            composable(route = SUCCESFUL_TRANSACTION_ROUTE) {
                 SuccessfulTransactionScreen(navController = navController)
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
