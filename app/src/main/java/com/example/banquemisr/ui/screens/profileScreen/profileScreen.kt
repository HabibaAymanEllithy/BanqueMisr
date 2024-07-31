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
import androidx.compose.material3.HorizontalDivider
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
import com.example.banquemisr.R
import com.example.banquemisr.ui.screens.reusableUI.ScreenField
import com.example.banquemisr.ui.screens.reusableUI.ScreenHeader

@Preview
@ExperimentalMaterial3Api
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf("#fef8e0".color, "#ffb6c1".color))
            )
    ) {
        ProfileScreenHeader()
        ProfileName()
        ProfileOptions()
    }

}

@Composable
fun ProfileOptions() {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        ScreenField("Personal information", "Your information", R.drawable.user)
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        ScreenField("Setting", "Change your settings", R.drawable.setting)
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        ScreenField("Payment history", "View your transactions", R.drawable.bank_account)
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        ScreenField("My favourite list", "View your favourites", R.drawable.star)
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
    }
}

@Composable
fun ProfileScreenHeader() {
    ScreenHeader("Profile", onClick = {})
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
        Text(text = "Asmaa Dosuky",fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.Black)
    }
}

val String.color
    get() = Color(parseColor(this))