package com.example.banquemisr.ui.screens

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
import com.example.banquemisr.ui.screens.reusableUI.ScreenField
import com.example.banquemisr.ui.screens.reusableUI.ScreenHeader
import com.example.bm_app.approutes.AppRoutes.Change_Password_Route
import com.example.bm_app.approutes.AppRoutes.Edit_Profile_Route
import com.example.bm_app.approutes.AppRoutes.Profile_Rute

@Composable
fun SettingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf("#fef8e0".color, "#ffb6c1".color))
            )
    ) {
        ScreenHeader("Setting", onClick = { navController.popBackStack() })

        ScreenField("Change Password", "Change Password", leadingIcon = R.drawable.lock_lines, onClick = {navController.navigate("$Change_Password_Route")})
        ScreenField("Edit Profile","Edit your information", leadingIcon = R.drawable.edit, onClick = {navController.navigate("$Edit_Profile_Route")})
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyComposablePreview() {
    val navController = rememberNavController()
    SettingScreen(navController = navController)
}