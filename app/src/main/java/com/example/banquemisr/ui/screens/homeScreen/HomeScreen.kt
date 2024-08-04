package com.example.banquemisr.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisr.R
import com.example.banquemisr.models.CurantBalanceViewModel
import com.example.banquemisr.screens.functionsusable.TextFormaterUSA

@Composable
fun HomeScreen() {
    val viewModel = CurantBalanceViewModel()  // Ensure ViewModel is correctly initialized
    val balance by viewModel.balance.collectAsState()

    val background = Brush.verticalGradient(
        colors = listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
        startY = 2000f,
        endY = 0f
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 40.dp, start = 11.dp, end = 11.dp, bottom = 10.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(
                        width = 0.dp,
                        color = colorResource(id = R.color.Gray_G40),
                        shape = CircleShape
                    )
                    .background(colorResource(id = R.color.Gray_G40)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.defult_user),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                )
            }

            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = "Welcome back , ",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Beige)
                )
                Text(
                    text = "User name",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "notifications",
                    modifier = Modifier
                        .size(45.dp)
                        .align(Alignment.CenterEnd),
                    contentScale = ContentScale.Crop
                )
            }
        }

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.elevatedCardColors(
                containerColor = colorResource(id = R.color.Beige)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
        ) {
            Text(
                text = "Current Balance ",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 10.dp, start = 10.dp)
            )
            TextFormaterUSA(
                balance= balance.toString(), fontSize = 28,
                color = Color.White, fontWeight = FontWeight.Bold
            )
        }

        Card(
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            Text(
                text = " Services ",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 10.dp, start = 10.dp)
            )

            Row(
                modifier = Modifier
                    .padding(start = 30.dp, end = 20.dp, top = 20.dp, bottom = 25.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageWithTextHome(
                    imageIcon = R.drawable.icon_transfare,
                    text = stringResource(id = R.string.str_transfer)
                )
                ImageWithTextHome(
                    imageIcon = R.drawable.icon_transactions,
                    text = stringResource(id = R.string.str_transaction)
                )
                ImageWithTextHome(
                    imageIcon = R.drawable.icon_cards,
                    text = stringResource(id = R.string.str_cards)
                )
                ImageWithTextHome(
                    imageIcon = R.drawable.icon_acount,
                    text = stringResource(id = R.string.str_account)
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.CenterVertically),
                text = "Recent transactions",
                fontSize = 20.sp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "View all",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

        CardTransactions()
    }
}

@Preview(showBackground = true, device = "id:pixel_6a")
@Composable
fun GreetingPreview() {
    HomeScreen()
}

@Composable
fun ImageWithTextHome(modifier: Modifier = Modifier, imageIcon: Int, text: String) {
    Column {
        Card(
            modifier = modifier.size(60.dp),
            colors = CardDefaults.cardColors(colorResource(id = R.color.Gray_G10))
        ) {
            Image(
                alignment = Alignment.Center,
                painter = painterResource(id = imageIcon),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = text
        )
    }
}

@Composable
fun CardTransactions() {
    var recipintName by remember { mutableStateOf("Name") }
    var balanceTransfer by remember { mutableStateOf("1000") }

    Card(
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row {
            Box(modifier = Modifier.size(100.dp)) {
                Image(
                    modifier = Modifier
                        .size(180.dp)
                        .padding(top = 0.dp, bottom = 0.dp),
                    painter = painterResource(id = R.drawable.icon_vesa),
                    contentDescription = null
                )
            }

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = recipintName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Gray_G900)
                )
                Text(
                    text = "Visa . Master Card . 12344",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Today 11:00 - Received",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.Beige),
                    text = balanceTransfer
                )
            }
        }
    }
}
