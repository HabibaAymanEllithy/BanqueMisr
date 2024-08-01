package com.example.banquemisr.screens.transferscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.banquemisr.R
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun TransferScreen(navController: NavController) {
    val background = Brush.verticalGradient(
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
                            contentDescription = "Back"
                        )
                    }
                },
            )
        },

    ) { innerPadding ->
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ScrollContent(
    navController: NavController,
) {
    var amountState by remember { mutableStateOf("") }
    var recipientNameState by remember { mutableStateOf("") }
    var recipientAccountState by remember { mutableStateOf("") }


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
                modifier = Modifier.align(Alignment.CenterVertically),
                borderColor = colorResource(id = R.color.Beige),
                text = "01",
                textColor = colorResource(id = R.color.Beige)
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
                modifier = Modifier.align(Alignment.CenterVertically),
                borderColor = Color.Gray,
                text = "02",
                textColor = Color.Gray
            )

            Box(
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .width(100.dp)
                    .height(2.dp)
                    .background(Color.Gray)
                    .align(Alignment.CenterVertically)
            )

            CircleWithNumWithText(
                modifier = Modifier.align(Alignment.CenterVertically),
                borderColor = Color.Gray,
                text = "03",
                textColor = Color.Gray
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(80.dp),
            modifier = Modifier.padding(start = 25.dp, top = 20.dp)
        ) {
            Text(
                color = colorResource(id = R.color.col_Text_gray),
                text = "Amount"
            )
            Text(
                color = colorResource(id = R.color.col_Text_gray),
                text = "Confirmation"
            )
            Text(
                color = colorResource(id = R.color.col_Text_gray),
                text = "Payment"
            )
        }

        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 20.dp),
            text = "How much are you sending?"
        )

        Column(
            modifier = Modifier.padding(start = 16.dp, top = 20.dp, end = 8.dp)
        ) {
            Text(
                color = colorResource(id = R.color.col_Text_gray),
                fontSize = 16.sp,
                text = "Choose Currency"
            )

            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
                modifier = Modifier
                    .padding(top = 20.dp, end = 10.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(start = 8.dp, top = 10.dp)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        color = Color.Black,
                        fontSize = 24.sp,
                        text = "1 USD = 48.4220 EGP"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Gray,
                        fontSize = 16.sp,
                        text = "Rate guaranteed (2h)"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        color = colorResource(id = R.color.col_Text_gray),
                        fontSize = 16.sp,
                        text = "You Send"
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        com.example.banquemisr.functionsusable.ExposedDropdownMenuBox()
                        OutlinedTextField(
                            value = amountState,
                            onValueChange = { amountState = it },
                            modifier = Modifier
                                .height(60.dp)
                                .width(200.dp)
                                .padding(top = 13.dp, end = 12.dp)
                        )
                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 10.dp)
                    )

                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        color = colorResource(id = R.color.col_Text_gray),
                        fontSize = 16.sp,
                        text = "Recipient Gets"
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        com.example.banquemisr.functionsusable.ExposedDropdownMenuBox()
                        OutlinedTextField(
                            value = amountState,
                            onValueChange = { amountState = it },
                            modifier = Modifier
                                .height(60.dp)
                                .width(200.dp)
                                .padding(top = 13.dp, end = 12.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(60.dp),
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp, end = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Recipient information",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.col_Text_gray)
                )
                Row(modifier = Modifier.clickable {
                }    ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_favorite_stare),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        text = "favorites",
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.Beige)
                    )
                    Image(modifier = Modifier.size(20.dp)
                        ,painter = painterResource(id = R.drawable.icon_wrightside)
                        , contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.padding(4.dp))


             TextFields(string1 = "Recipient Name", string2 = "Enter recipient name")


Spacer(modifier = Modifier.padding(8.dp))

            TextFields(string1 = "Recipient Account ", string2 = "Enter Recipient Account Number ")

Spacer(modifier = Modifier.padding(20.dp))

            FilledTonalButton(
                onClick = { },
                shape = RoundedCornerShape(10.dp)
                ,colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = colorResource(id = R.color.Beige))
                ,modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Continue",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                )
            }

                }
            }
        }



@Composable
fun CircleWithNumWithText(
    modifier: Modifier = Modifier,
    borderColor: Color,
    text: String,
    textColor: Color
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = CircleShape
            )
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun TextFields(string1: String, string2: String, modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth(),verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.Start) {
        Text(
            text = string1,
            modifier = modifier.padding(horizontal = 12.dp),
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

@Preview(showBackground = true)
@Composable
fun TransferScreenPreview() {
    TransferScreen(navController = rememberNavController())
}