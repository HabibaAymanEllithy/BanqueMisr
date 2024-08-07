package com.example.banquemisr.ui.screens.profileScreen

import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.banquemisr.R
import com.example.banquemisr.ui.screens.reusableUI.ScreenField
import com.example.banquemisr.ui.screens.reusableUI.ScreenHeader
import com.example.bm_app.approutes.AppRoutes.MORE_ROUTE
import com.example.bm_app.approutes.AppRoutes.Profile_Information_Route
import com.example.bm_app.approutes.AppRoutes.Setting_Route

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf("#fef8e0".color, "#ffb6c1".color))
            )
    ) {
        ScreenHeader("Profile", onClick = { navController.popBackStack() })

        ProfileName()
        ScreenField(
            "Personal information",
            "Your information",
            R.drawable.user,
            onClick = {navController.navigate("$Profile_Information_Route")}
        )
        ScreenField(
            "Setting",
            "Change your settings",
            R.drawable.setting,
            onClick = { navController.navigate("$Setting_Route") })
        ScreenField("Payment history", "View your transactions", R.drawable.bank_account)
        ScreenField("My favourite list", "View your favourites", R.drawable.star)

    }

}

@Composable
fun ProfileOptions() {
    Column(modifier = Modifier.padding(top = 8.dp)) {

    }
}

@Composable
fun ProfileName() {
    Row(
        modifier = Modifier
            //.padding(vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(color = Color(0xFFccced3))
                .size(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "AD", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Asmaa Dosuky",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}

val String.color
    get() = Color(parseColor(this))

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyComposablePreview() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}