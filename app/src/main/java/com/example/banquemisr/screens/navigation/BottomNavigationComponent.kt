package com.example.banquemisr.screens.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationComponent() {
    val navController = rememberNavController()

    val items = listOf(
        Screen.Home,
        Screen.Transfer,
        Screen.Transaction,
        Screen.Card,
        Screen.More
    )

    // A surface container using the 'background' color from the theme
    Surface(

    ) {
        Scaffold(
            bottomBar = {
                Card(modifier = Modifier.height(70.dp)) {
                    BottomNavigation(
                        modifier = Modifier.height(70.dp),
                        backgroundColor = Color.White
                    ) {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        var currentDestination = navBackStackEntry?.destination

                        items.forEach { screen ->
                            var isSelected =
                                currentDestination?.hierarchy?.any { it.route == screen.route } == true
                            BottomNavigationItem(
                                icon = {
                                    Icon(
                                        modifier = Modifier.size(20.dp),
                                        painter = painterResource(
                                            id = if (isSelected) screen.selected_icon else screen.unselected_icon
                                        ),
                                        tint = if (isSelected) {Color.Red} else{ Color.Gray} ,
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        modifier = Modifier.align(Alignment.CenterVertically),
                                        fontSize = 10.sp,
                                        text = screen.title,
                                        color = if (isSelected) Color.Black else Color.Gray
                                    )
                                },

                                selected = isSelected,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            }
        ) { _ ->

        }
    }
}

@Preview
@Composable
fun BottomNavigationComponentPreview() {
    BottomNavigationComponent()
}