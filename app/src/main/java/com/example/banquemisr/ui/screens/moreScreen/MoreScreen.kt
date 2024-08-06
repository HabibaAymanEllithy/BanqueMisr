package com.example.banquemisr.ui.screens.moreScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.banquemisr.R
import com.example.banquemisr.ui.screens.profileScreen.color
import com.example.banquemisr.ui.screens.reusableUI.MoreField
import com.example.banquemisr.ui.screens.reusableUI.ScreenHeader
import com.example.bm_app.approutes.AppRoutes.Profile_Rute

@Composable
fun MoreScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf("#fef8e0".color, "#ffb6c1".color))
            )
    ) {
        ScreenHeader("More", onClick = {navController.popBackStack()})
        MoreField(
            "Transfer from website",
            leadingIcon = R.drawable.web_site,
        )
        MoreField(
            "Favourites",
            leadingIcon = R.drawable.star,
        )
        MoreField(
            "Profile",
            leadingIcon = R.drawable.user,
            onClick = { navController.navigate("$Profile_Rute") }
        )
        MoreField(
            "Help",
            leadingIcon = R.drawable.question
        )
        MoreField(
            "Logout",
            leadingIcon = R.drawable.log_out
        )
    }

}

@Composable
fun MoreScreenHeader() {
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyComposablePreview() {
    val navController = rememberNavController()
    MoreScreen(navController = navController)
}