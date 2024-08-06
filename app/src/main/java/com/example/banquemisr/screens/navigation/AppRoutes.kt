


package com.example.bm_app.approutes


import DynamicLoadingScreen

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.banquemisr.models.SignUpViewModel
import com.example.banquemisr.screens.HomeScreen
import com.example.banquemisr.screens.addCard.AccountConnectedScreen
import com.example.banquemisr.screens.addCard.OTPScreen
import com.example.banquemisr.screens.addCard.SelectCurrencyScreen
import com.example.banquemisr.screens.addCard.addCardScreen
import com.example.banquemisr.screens.signIn.SignInScreen
import com.example.banquemisr.screens.signUp.SignUpScreen
import com.example.banquemisr.screens.signUp.SignUpScreen2
import com.example.banquemisr.screens.splash.SplashScreen
import com.example.banquemisr.ui.screens.SettingScreen
import com.example.banquemisr.ui.screens.moreScreen.MoreScreen
import com.example.banquemisr.ui.screens.profileScreen.ProfileScreen
import com.example.banquemisr.ui.screens.notification.NotificationScreen
import com.example.banquemisr.ui.screens.transactionScreen.SuccessfulTransactionScreen
import com.example.banquemisr.ui.screens.transactionScreen.TransActionScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferAmountScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferConfirmationScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferPaymentScreen
import com.example.bm_app.approutes.AppRoutes.ACCOUNT_CONNECTED_ROUTE
import com.example.bm_app.approutes.AppRoutes.ADD_CARD_ROUTE
import com.example.bm_app.approutes.AppRoutes.CARD_ROUTE
import com.example.bm_app.approutes.AppRoutes.CONNECTING_SCREEN_ROUTE
import com.example.bm_app.approutes.AppRoutes.HOME_ROUTE
import com.example.bm_app.approutes.AppRoutes.MORE_ROUTE
import com.example.bm_app.approutes.AppRoutes.OTP_ROUTE
import com.example.bm_app.approutes.AppRoutes.Profile_Rute
import com.example.bm_app.approutes.AppRoutes.SELECT_CURRENCY_ROUTE
import com.example.bm_app.approutes.AppRoutes.SIGNIN_ROUTE
import com.example.bm_app.approutes.AppRoutes.SIGN_UP_COMPLETE_ROUTE
import com.example.bm_app.approutes.AppRoutes.SPLASH_ROUTE
import com.example.bm_app.approutes.AppRoutes.SUCCESSFUL_TRANSACTION_ROUTE
import com.example.bm_app.approutes.AppRoutes.Setting_Route
import com.example.bm_app.approutes.AppRoutes.TRANSACTION_ROUTE
import com.example.bm_app.approutes.AppRoutes.TRANSFERAMOUNT_ROUTE


object AppRoutes {
    const val SIGN_UP_ROUTE = "signUp"
    const val SIGN_UP_COMPLETE_ROUTE = "SignUpComplete"
    const val SIGNIN_ROUTE = "signIn"
    const val SPLASH_ROUTE = "splash"
    const val HOME_ROUTE = "home"
    const val TRANSFERAMOUNT_ROUTE = "transferAmount"
    const val TRANSFERCONFIRMATION_ROUTE = "transferConfirmation"
    const val TRANSFERPAYMENT_ROUTE = "transferPayment"
    const val TRANSACTION_ROUTE = "transaction"
    const val CARD_ROUTE = "card"
    const val MORE_ROUTE = "more"
    const val SUCCESSFUL_TRANSACTION_ROUTE = "successfulTransaction"

    const val ADD_CARD_ROUTE = "addCard"
    const val ACCOUNT_CONNECTED_ROUTE = "accountConnected"
    const val CONNECTING_SCREEN_ROUTE = "connectingScreen"
    const val OTP_ROUTE = "otp"
    const val SELECT_CURRENCY_ROUTE = "selectCurrency"

    const val Profile_Rute = "profile"
    const val Setting_Route = "Setting"
   // const val FIELD_TRANSACTION_ROUTE = "fieldTransaction"

    const val NOTIFICATION_ROUTE = "notification"
    const val SUCCESFUL_TRANSACTION_ROUTE = "successfulTransaction"

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
   // val addCardViewModel: AddCardViewModel = viewModel()
    val signUpViewModel: SignUpViewModel = viewModel()


    NavHost(navController = navController, startDestination = AppRoutes.HOME_ROUTE)
    {
        composable(route = AppRoutes.SIGN_UP_ROUTE) { SignUpScreen(navController) }
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

            composable(route = ADD_CARD_ROUTE) {
                addCardScreen(navController =navController )
            }
            composable(route = ACCOUNT_CONNECTED_ROUTE) {
                AccountConnectedScreen(navController)
            }
            composable(route = OTP_ROUTE) {
                OTPScreen(navController)
            }
            composable(route = CONNECTING_SCREEN_ROUTE) {
                DynamicLoadingScreen(navController)
            }
            composable(route = SELECT_CURRENCY_ROUTE) {
               SelectCurrencyScreen(navController)
            }
            composable(route = SPLASH_ROUTE) {
                SplashScreen(navController)
            }
            composable(route = HOME_ROUTE) {
                HomeScreen(navController, viewModel = viewModel())
            }
            composable(route = TRANSFERAMOUNT_ROUTE) {}
            composable(route = TRANSACTION_ROUTE) {
                TransActionScreen(navController = navController)
            }
            composable(route = CARD_ROUTE) {
                // CardsScreen(navController = navController)
            }
            composable(route = MORE_ROUTE) {
                MoreScreen(navController)
            }
            composable(route = SUCCESSFUL_TRANSACTION_ROUTE) {
                SuccessfulTransactionScreen(navController = navController)
            }
            composable(route = Profile_Rute){
                ProfileScreen(navController = navController)
            }
            composable(route = Setting_Route){
                SettingScreen(navController = navController)
            }

        composable(route = AppRoutes.SIGNIN_ROUTE) { SignInScreen(navController) }

        composable(route = AppRoutes.HOME_ROUTE) { HomeScreen(navController = navController, viewModel = viewModel()) }
        composable(route = AppRoutes.TRANSFERAMOUNT_ROUTE) { TransferAmountScreen(navController) }
        composable(
            route = "${AppRoutes.TRANSFERCONFIRMATION_ROUTE}/{amount}/{recipientName}/{recipientAccount}/{amountEgp}",
            arguments = listOf(
                navArgument("amount") { type = NavType.StringType },
                navArgument("recipientName") { type = NavType.StringType },
                navArgument("recipientAccount") { type = NavType.StringType }
                , navArgument("amountEgp") { type = NavType.StringType }

            )
        ) { backStackEntry ->
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            val recipientName = backStackEntry.arguments?.getString("recipientName") ?: ""
            val recipientAccount = backStackEntry.arguments?.getString("recipientAccount") ?: ""
            val amountEgp = backStackEntry.arguments?.getString("amountEgp") ?: ""
            TransferConfirmationScreen(navController, amount.toDouble(), recipientName, recipientAccount,amountEgp.toDouble())
        }

        composable(
            route = "${AppRoutes.TRANSFERPAYMENT_ROUTE}/{amount}/{recipientName}/{recipientAccount}/{amountEgp}",
            arguments = listOf(
                navArgument("amount") { type = NavType.StringType },
                navArgument("recipientName") { type = NavType.StringType },
                navArgument("recipientAccount") { type = NavType.StringType }
                , navArgument("amountEgp") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            val recipientName = backStackEntry.arguments?.getString("recipientName") ?: ""
            val recipientAccount = backStackEntry.arguments?.getString("recipientAccount") ?: ""
            val amountEgp = backStackEntry.arguments?.getString("amountEgp") ?: ""
            TransferPaymentScreen(navController, amount.toDouble(), recipientName, recipientAccount,amountEgp.toDouble())
        }
        composable(route = AppRoutes.TRANSACTION_ROUTE) { TransActionScreen(navController) }
        composable(route = AppRoutes.NOTIFICATION_ROUTE) { NotificationScreen(navController)
        }
        composable(route = AppRoutes.SUCCESFUL_TRANSACTION_ROUTE) { SuccessfulTransactionScreen(navController) }
        composable(route = AppRoutes.CARD_ROUTE) {
            //CardsScreen(navController)
             }
        composable(route = AppRoutes.MORE_ROUTE) {
        //MoreScreen(navController)
             }
        }
}



