package com.example.banquemisr.screens.addCard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.banquemisr.R
import com.example.banquemisr.screens.signIn.TextFields
import com.example.banquemisr.ui.screens.profileScreen.color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addCardScreen(navController: NavController, modifier: Modifier = Modifier) {

    val cardHolderName = remember { mutableStateOf("") }
    val cardNO = remember { mutableStateOf("") }
    val CVV = remember { mutableStateOf("") }
    val expiryDate = remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.Gredient),
                    titleContentColor = colorResource(id = R.color.Gray_G900)
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Add Card",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W500
                        )

                    }

                }
                ,actions = {
                    Box(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { navController.popBackStack() },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Cancel",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.W500
                        )
                    }
                }
            )
        }
<<<<<<< HEAD
    ) { _ ->
//        addCard(
//            navController,cardHolderName.value,cardNO.value,CVV.value,expiryDate.value, innerPadding
//        )
    }
}

//@Composable
//fun addCard(navController: NavController,cardHolder:String,CardNo:String,CVV:String,expiryDate:String,paddingValues: PaddingValues){
//TextFields(string1 = "cardHolder Name", string2 = "Enter cardHolder Name", icon =R.drawable.transparent_icon , state =cardHolder, keyboard = , isPassword = )
//
//
//}
=======
    ) { innerPadding ->
        addCard(
            navController,cardHolderName,cardNO,CVV,expiryDate, innerPadding
        )
    }
}

@Composable
fun addCard(navController: NavController, cardHolder:MutableState<String>, CardNo: MutableState<String>, CVV:MutableState<String>, expiryDate:MutableState<String>, innerPadding: PaddingValues,modifier: Modifier=Modifier){
    val scrollState = rememberScrollState()
    var background = Brush.verticalGradient(
        listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
        startY = 2000f,
        endY = 0f
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()

            .background(background)
            .verticalScroll(scrollState).padding(innerPadding)
    ) {


        TextFields(
            string1 = "cardHolder Name",
            string2 = "Enter cardHolder Name",
            icon = R.drawable.transparent,
            state = cardHolder,
            keyboard = KeyboardOptions(keyboardType = KeyboardType.Text),
            isPassword = false
        )
        TextFields(
            string1 = "Card NO",
            string2 = "Card NO",
            icon = R.drawable.transparent_icon,
            state = cardHolder,
            keyboard = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            isPassword = false
        )


    }









}
>>>>>>> master

@Preview
@Composable
fun addCardPreview(){
    addCardScreen(navController = rememberNavController())
}