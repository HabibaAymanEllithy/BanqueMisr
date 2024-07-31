package com.example.banquemisr.ui.screens.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banquemisr.R
import com.example.banquemisr.ui.screens.reusableUI.profileField.ProfileField

@Preview
@ExperimentalMaterial3Api
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profile") },
                modifier = Modifier.background(Color.White)
            )
        },
        content = { _ ->
            Column(modifier = Modifier.padding(16.dp)) {
                ProfileOptions()
            }
        }
    )
}

@Composable
fun ProfileOptions() {
    Column {
        ProfileField("Personal information", "Your information", R.drawable.user)
        HorizontalDivider(thickness = 2.dp, color = Color.Black)
        ProfileField("Setting", "Change your settings", R.drawable.setting)
        HorizontalDivider(thickness = 2.dp, color = Color.Black)
        ProfileField("Payment history", "View your transactions", R.drawable.bank_account)
        HorizontalDivider(thickness = 2.dp, color = Color.Black)
        ProfileField("My favourite list", "View your favourites", R.drawable.star)
        HorizontalDivider(thickness = 2.dp, color = Color.Black)
    }
}