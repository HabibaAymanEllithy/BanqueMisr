package com.example.banquemisr.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.banquemisr.R

@Composable
fun HomeScreen(navController: NavController) {


    var background = Brush.verticalGradient(
        listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
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
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), //image user
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray, CircleShape)
            )



            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = "Welcome back , ",
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.Beige)
                )
                Text(
                    text = "User name",
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // notification image
                    contentDescription = "notifications",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterEnd),
                    contentScale = ContentScale.Crop
                )
            }
        }

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ), colors = CardDefaults.elevatedCardColors(
                containerColor = colorResource(id = R.color.Beige)
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 8.dp)
        ) {
            Text(
                text = "Current Balance ",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 10.dp, start = 10.dp),
            )
            // adding format to the text
            Text(
                text = "$200000000",
                fontSize = 28.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 20.dp, start = 10.dp)
            )
        }

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ), colors = CardDefaults.elevatedCardColors(
                containerColor = Color.White
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 15.dp)
        ) {
            Text(
                text = " Services ",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 10.dp, start = 10.dp),
            )

            Row(
                modifier = Modifier
                    .padding(start = 30.dp, end = 20.dp, top = 20.dp, bottom = 25.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ImageWithText(
                    modifier = Modifier,
                    imageIcon = R.drawable.ic_launcher_foreground,  // image of transfer
                    text = stringResource(id = R.string.str_transfer)
                )

                ImageWithText(
                    modifier = Modifier,
                    imageIcon = R.drawable.ic_launcher_foreground, // image of transaction
                    text = stringResource(id = R.string.str_transaction)
                )

                ImageWithText(
                    modifier = Modifier,
                    imageIcon = R.drawable.ic_launcher_foreground, // image of cards
                    text = stringResource(id = R.string.str_cards)
                )

                ImageWithText(
                    modifier = Modifier,
                    imageIcon = R.drawable.ic_launcher_foreground, // image of account
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
                text = "Recent transactions", fontSize = 20.sp, color = Color.Black
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
    HomeScreen(navController = NavController(LocalContext.current))
}

@Composable
fun ImageWithText(modifier: Modifier, imageIcon: Int, text: String) {
    Column {

        Card(
            modifier = modifier
                .size(60.dp),
            colors = CardDefaults.cardColors(colorResource(id = R.color.light_gray))
        )
        {
            Image(
                alignment = Alignment.Center, painter = painterResource(id = imageIcon),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)

            )
        }
        Text(text = text)
    }
}

@Composable
fun CardTransactions() {
    Card(
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Row {
            Box(modifier = Modifier.size(80.dp))
            {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 0f.dp, bottom = 0f.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // image vesa
                    contentDescription = null
                )

            }

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = "Name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Text(
                    text = "Visa . Master Card . 12344",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )

                Text(
                    text = "Today 11:00 - Received",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier
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
                    color = colorResource(id = R.color.Beige), modifier = Modifier
                        .align(Alignment.Top), text = "$1000"
                )
            }
        }
    }
}