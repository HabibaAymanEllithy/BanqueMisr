package com.example.banquemisr.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.banquemisr.screens.CardsScreen
import com.example.banquemisr.screens.MenueScreen
import com.example.banquemisr.screens.TransActionScreen
import com.example.banquemisr.ui.screens.homeScreen.HomeScreen
import com.example.banquemisr.ui.screens.transferScreen.TransferAmountScreen
import com.example.banquemisr.R







@Composable
fun AppNavHost(navController: NavHostController,modifier: Modifier=Modifier) {

    NavHost(navController = navController, startDestination = Screen.Home.route)
    {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }

        composable(route = Screen.Transfer.route) {
            TransferAmountScreen(navController = navController)
        }

        composable(route = Screen.Card.route) {
            TransActionScreen(navController = navController)
        }

        composable(route = Screen.Account.route) {
            CardsScreen(navController = navController)
        }

        composable(route = Screen.More.route) {
            MenueScreen(navController = navController)
        }

    }
}

    sealed class Screen (
        val route:String
        , val title:String
        , val unselected_icon:Int
        , val selected_icon:Int
    ) {
        object Home : Screen(
            route = "home",
            title = "Home",
            unselected_icon = R.drawable.bar_home,
            selected_icon = R.drawable.bar_s_home
        )

        object Transfer : Screen(
            route = "transfer",
            title = "Transfer",
            unselected_icon = R.drawable.bar_transfare,
            selected_icon = R.drawable.bar_s_transfare
        )

        object Card : Screen(
            route = "card",
            title = "Card",
            unselected_icon = R.drawable.bar_transactions,
            selected_icon = R.drawable.bar_s_transactions
        )

        object Account : Screen(
            route = "account",
            title = "Account",
            unselected_icon = R.drawable.bar_cards,
            selected_icon = R.drawable.bar_s_cards
        )

        object More : Screen(
            route = "more",
            title = "More",
            unselected_icon = R.drawable.bar_more,
            selected_icon = R.drawable.bar_s_more
        )

    }