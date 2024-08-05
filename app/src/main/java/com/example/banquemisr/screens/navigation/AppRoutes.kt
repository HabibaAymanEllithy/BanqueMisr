


package com.example.bm_app.approutes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.banquemisr.models.SignUpViewModel
import com.example.banquemisr.screens.HomeScreen
import com.example.banquemisr.screens.signIn.SignInScreen
import com.example.banquemisr.screens.signUp.SignUpScreen
import com.example.banquemisr.screens.signUp.SignUpScreen2
import com.example.banquemisr.ui.screens.notification.NotificationScreen
import com.example.banquemisr.ui.screens.transactionScreen.SuccessfulTransactionScreen
import com.example.banquemisr.ui.screens.transactionScreen.TransActionScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferAmountScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferConfirmationScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferPaymentScreen
import com.example.bm_app.approutes.AppRoutes.SIGN_UP_COMPLETE_ROUTE


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
    const val NOTIFICATION_ROUTE = "notification"
    const val SUCCESFUL_TRANSACTION_ROUTE = "successfulTransaction"

}

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












//package com.example.banquemisr.screens.navigation
//
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.example.banquemisr.screens.HomeScreen
//
//import com.example.banquemisr.screens.signIn.SignInScreen
//import com.example.banquemisr.screens.signUp.SignUpScreen
//import com.example.banquemisr.screens.signUp.SignUpScreen2
//import com.example.banquemisr.screens.splash.SplashScreen
//import com.example.banquemisr.ui.screens.notification.NotificationScreen
//import com.example.banquemisr.ui.screens.transactionScreen.SuccessfulTransactionScreen
//import com.example.banquemisr.ui.screens.transactionScreen.TransActionScreen
//import com.example.banquemisr.ui.screens.transferScreen.TransferAmountScreen
//import com.example.banquemisr.ui.screens.transferScreen.TransferConfirmationScreen
//import com.example.banquemisr.ui.screens.transferScreen.TransferPaymentScreen
//
//object AppRoutes {
//    const val SIGN_UP_ROUTE = "signUp"
//    const val SIGN_UP_COMPLETE_ROUTE = "SignUpComplete"
//    const val SIGNIN_ROUTE = "signIn"
//    const val SPLASH_ROUTE = "splash"
//    const val HOME_ROUTE = "home"
//    const val TRANSFERAMOUNT_ROUTE = "transferAmount"
//    const val TRANSFERCONFIRMATION_ROUTE = "transferConfirmation"
//    const val TRASFERPAYMENT_ROUTE = "transferPayment"
//    const val TRANSACTION_ROUTE = "transaction"
//    const val CARD_ROUTE = "card"
//    const val MORE_ROUTE = "more"
//    const val SUCCESSFUL_TRANSACTION_ROUTE = "successfulTransaction"
//    const val NOTIFICATION_ROUTE = "notification"
//    const val SUCCESFUL_TRANSACTION_ROUTE = "successfulTransaction"
//
//
//    @Composable
//
//    fun AppNavigation(modifier: Modifier = Modifier) {
//
//        val navController = rememberNavController()
//
//        NavHost(
//            navController = navController,
//            startDestination = HOME_ROUTE,
//        ) {
//            composable(route = SIGN_UP_ROUTE) {
//                SignUpScreen(navController)
//            }
//
//            composable(
//                route = "$SIGN_UP_COMPLETE_ROUTE/{fullName}/{email}/{password}",
//                arguments = listOf(
//                    navArgument("fullName") { type = NavType.StringType },
//                    navArgument("email") { type = NavType.StringType },
//                    navArgument("password") { type = NavType.StringType }
//                )
//            ) {
//                val fullName = it.arguments?.getString("fullName") ?: ""
//                val email = it.arguments?.getString("email") ?: ""
//                val password = it.arguments?.getString("password") ?: ""
//
//                SignUpScreen2(navController,fullName, email, password)
//            }
//
//            composable(route = SIGNIN_ROUTE) {
//                SignInScreen(navController)
//            }
//            composable(route = SPLASH_ROUTE) {
//                SplashScreen(navController)
//            }
//            composable(route = HOME_ROUTE) {
//                HomeScreen(navController)
//            }
//            composable(route = TRANSFERAMOUNT_ROUTE) {
//                TransferAmountScreen(navController)
//            }
//
//            composable(route = "$TRANSFERCONFIRMATION_ROUTE  /{amount}/{recipientName}/{recipientAccount}"
//            , arguments =
//                listOf(navArgument("amount"){type = NavType.FloatType}
//                        , navArgument("recipientName"){type=NavType.StringType}
//                        , navArgument("recipientAccount"){type=NavType.StringType})
//            ) {
//                val amount = it.arguments?.getDouble("amount") ?: ""
//                val recipientName = it.arguments?.getString("recipientName") ?: ""
//                val recipientAccount = it.arguments?.getString("recipientAccount") ?: ""
//
//                 TransferConfirmationScreen(navController, amount =amount , recipientName =recipientName, recipientAccount =recipientAccount)
//            }
//
//            composable(route = "$TRASFERPAYMENT_ROUTE  /{amount}/{recipientName}/{recipientAccount}"
//            , arguments = listOf(navArgument("amount"){type = NavType.FloatType}
//                    , navArgument("recipientName"){type=NavType.StringType}
//            , navArgument("recipientAccount"){type=NavType.StringType})) {
//
//                val amount = it.arguments?.getDouble("amount") ?: ""
//                val recipientName = it.arguments?.getString("recipientName") ?: ""
//                val recipientAccount = it.arguments?.getString("recipientAccount") ?: ""
//
//                 TransferPaymentScreen(navController = navController)
//            }
//            composable(route = TRANSACTION_ROUTE) {
//                TransActionScreen(navController = navController)
//            }
//            composable(route = NOTIFICATION_ROUTE) {
//                 NotificationScreen(navController = navController)
//            }
//            composable(route = SUCCESFUL_TRANSACTION_ROUTE) {
//                 SuccessfulTransactionScreen(navController = navController)
//            }
//            composable(route = CARD_ROUTE) {
//                // CardsScreen(navController = navController)
//            }
//            composable(route = MORE_ROUTE) {
//                // MenueScreen(navController = navController)
//            }
//            composable(route = SUCCESSFUL_TRANSACTION_ROUTE) {
//                SuccessfulTransactionScreen(navController = navController)
//            }
////            composable(route = FIELD_TRANSACTION_ROUTE) {
////                // FieldTransactionScreen(navController = navController)
////
////            }
//        }
//    }
//}
