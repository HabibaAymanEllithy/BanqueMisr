package com.example.banquemisr.screens.transferscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.banquemisr.R
import com.example.banquemisr.ui.theme.MyTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferScreen(navController: NavController) {
    var background = Brush.verticalGradient(
        listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
        startY = 2000f,
        endY = 0f
    )
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .background(background)
            .nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(id = R.color.Gredient),
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        "Transfer",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            ScrollContent(navController)
        }

    }
}

@Composable
fun ScrollContent(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {

        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {

            CircleWithNumWithText(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                colorResource(id = R.color.Beige),
                "01",
                colorResource(id = R.color.Beige)
            )
            Box(
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .width(100.dp)
                    .height(2.dp)
                    .background(colorResource(id = R.color.Beige))
                    .align(Alignment.CenterVertically)
            )

            CircleWithNumWithText(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                Color.Gray,
                "02",
                Color.Gray
            )

            Box(
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .width(100.dp)
                    .height(2.dp)
                    .background(color = Color.Gray)
                    .align(Alignment.CenterVertically)
            )

            CircleWithNumWithText(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                Color.Gray,
                "03",
                Color.Gray

            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(80.dp),
            modifier = Modifier.padding(start = 40.dp, top = 20.dp)
        ) {
            Text(color = colorResource(id = R.color.col_Text_gray)
                ,text = "Amount")
            Text(color = colorResource(id = R.color.col_Text_gray)
                ,text = "Confirmation")
            Text(color = colorResource(id =R.color.col_Text_gray)
                ,text = "Payment")
        }

        Text(
            fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(start = 16.dp, top = 20.dp), text = "How much are you sending ?"
        )

        Column(
            modifier = Modifier.padding(start = 16.dp, top = 20.dp, end = 8.dp)
        ) {

            Text(
                color = Color.DarkGray, fontSize = 16.sp, text = "Choose Currecy"
            )

            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ), colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White
                ), modifier = Modifier
                    .padding(top = 20.dp, end = 10.dp)
                    .fillMaxWidth()
            ) {

                Column(modifier = Modifier.padding(start = 8.dp, top = 10.dp)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        color = Color.Black,
                        fontSize = 24.sp,
                        text = "1 USD = 48.4220 EGP", modifier = Modifier.padding(start=4.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(top = 8.dp , start = 8.dp), color = Color.Gray,
                        fontSize = 14.sp, text = "Rate guaranteed (2h)"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 8.dp), color = Color.DarkGray,
                        fontSize = 16.sp, text = "You Send"
                    )

                    Row(modifier = Modifier.padding(end = 8.dp)
                        ,horizontalArrangement = Arrangement.spacedBy(35.dp)) {
                        com.example.banquemisr.ui.theme.ExposedDropdownMenuBox()
                        OutlinedTextField(value = "",
                            onValueChange = {}, modifier = Modifier
                                .height(60.dp)
                                .width(200.dp)
                                .padding(top = 13.dp, end = 8.dp))
                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 10.dp)
                    )

                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 8.dp), color = Color.DarkGray,
                        fontSize = 16.sp, text = "Recipient Gets"
                    )

                    Row(modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                    ,horizontalArrangement = Arrangement.spacedBy(35.dp)) {
                        com.example.banquemisr.ui.theme.ExposedDropdownMenuBox()
                        OutlinedTextField(value = "",
                            onValueChange = {}, modifier = Modifier
                                .height(60.dp)
                                .width(200.dp)
                                .padding(top = 13.dp, end = 8.dp))
                    }

                }

            }
Spacer(modifier = Modifier.padding(8.dp))
            Row (horizontalArrangement = Arrangement.spacedBy(100.dp)
                ,modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp, end = 10.dp)
                    .fillMaxWidth())
            {
                Text(
                    text = "Recipient information"
                , fontSize = 16.sp
                        , color = Color.Black)
                Row {
                    Image(painter =painterResource(id = R.drawable.icon_favorite_stare)
                        , contentDescription =null
                    , modifier = Modifier
                            .padding(end = 5.dp)
                            .size(20.dp))

                    Text(
                        text = "Favourite"
                    , fontSize = 16.sp
                    , color = colorResource(id = R.color.Beige))

                    Image(painter = painterResource(id = R.drawable.icon_wrightside)
                        , contentDescription = null
                    ,modifier = Modifier.size(20.dp))
                }
            }
Spacer(modifier = Modifier.padding(12.dp))
            Column {
                TextFields(string1 = "Recipient Name", string2 = "Enter Recipient Name")
                Spacer(modifier = Modifier.padding(8.dp))
                TextFields(string1 = "Recipient Account", string2 = "Enter Recipient Account")

                Button_use()
            }

        }
    }
}



@Preview(showBackground = true, device = "id:pixel_6a")
@Composable
fun TransferScreenPreview() {
    TransferScreen(navController = rememberNavController())
}


@Composable
fun CircleWithNumWithText(modifier: Modifier, bordercolor: Color, text: String, textcolor: Color) {
    Row {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .border(color = bordercolor, shape = CircleShape, width = 2.dp)
                    .background(Color.White, shape = CircleShape)
                    .clip(CircleShape)
            ) {
                Text(
                    text = text, color = textcolor, modifier = Modifier
                        .padding(all = 2.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}




@Composable
fun TextFields(string1: String, string2: String, modifier: Modifier = Modifier) {
        var state by remember { mutableStateOf("") }
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
            Text(
                text = string1,
                modifier = modifier.padding(horizontal = 16.dp),
                fontSize = 16.sp,
                color = colorResource(id = R.color.col_Text_gray),
                fontWeight = FontWeight.W400,

                )
            OutlinedTextField(
                value = state,
                onValueChange = { state = it },
                placeholder = { Text(text = string2, color = Color.Gray) },


                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(9.dp)),
                shape = RoundedCornerShape(9.dp)


            )
        }
    }

@Composable
fun Button_use(){
    FilledTonalButton(
        onClick = { },
        shape = RoundedCornerShape(10.dp)
        ,colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = colorResource(id = R.color.Beige))
        ,modifier = Modifier
            .fillMaxWidth()
            .sizeIn(20.dp)
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 10.dp, top = 10.dp)
                .align(alignment = Alignment.CenterVertically)
        )
    }
}