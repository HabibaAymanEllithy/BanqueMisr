package com.example.banquemisr.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.banquemisr.R
import com.example.banquemisr.screens.signUp.DatePickerButton
import com.example.banquemisr.screens.signUp.TextFields
import com.example.banquemisr.ui.screens.profileScreen.color
import com.example.banquemisr.ui.screens.reusableUI.ScreenHeader

@Composable
fun EditProfileScreen(navController: NavController) {
    var name = remember { mutableStateOf<String>("") }
    var email = remember { mutableStateOf<String>("") }
    var country = remember { mutableStateOf<String>("") }
    val mDate = remember { mutableStateOf<String>("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf("#fef8e0".color, "#ffb6c1".color))
            )
    ) {
        ScreenHeader("Edit Profile", onClick = { navController.popBackStack() })
        TextFields(
            string1 = "Full Name",
            string2 = "Enter Your Name",
            icon = R.drawable.eye,
            state = name,
            KeyboardOptions(keyboardType = KeyboardType.Password),
            isPassword = true,
            size = 0
        )
        TextFields(
            string1 = "Email",
            string2 = "Enter Your Email",
            icon = R.drawable.eye,
            state = email,
            KeyboardOptions(keyboardType = KeyboardType.Password),
            isPassword = true,
            size = 0
        )
        TextFields(
            string1 = "Country",
            string2 = "Enter Your Country",
            icon = R.drawable.eye,
            state = country,
            KeyboardOptions(keyboardType = KeyboardType.Password),
            isPassword = true,
            size = 0
        )

        DatePickerButton(mDate = mDate)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.Beige)
            ),
            shape = RoundedCornerShape(9.dp),
        ) {
            Text(
                text = "Save",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500
            )
        }

    }
}


@Preview
@Composable
fun pre() {
    var navController = rememberNavController()
    EditProfileScreen(navController = navController)
}