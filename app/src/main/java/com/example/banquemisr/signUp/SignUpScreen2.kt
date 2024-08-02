@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.banquemisr.signUp

import DropdownMenuBox
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.banquemisr.R

import java.util.Calendar
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen2(navController: NavController, modifier: Modifier = Modifier) {
    var country = remember { mutableStateOf<String>("") }
    var mDate = remember { mutableStateOf<String>("") }
    Scaffold(

        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.Gredient),
                    titleContentColor = colorResource(id = R.color.Gray_G900),

                    ),
                navigationIcon = {
                    IconButton(onClick = {  navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },

                title = {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W500
                        )
                    }
                }


            )
        },
    ) { innerPadding ->
        SignUp2(innerPadding, navController,country,mDate)
    }
}


@Composable

fun SignUp2(
    innerPadding: PaddingValues,
    navController: NavController,
    country: MutableState<String>,
    mDate: MutableState<String>,
    modifier: Modifier = Modifier
) {

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
            .verticalScroll(scrollState)
            .padding(innerPadding)
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Box(
            contentAlignment = Alignment.Center, modifier = modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Speedo Transfer",
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.W600
            )

        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Welcome To Banque Misr!",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.W600
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Let's complete your profile",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            bottomSheet(country)
            Spacer(modifier = Modifier.height(10.dp))
            DatePickerButton(mDate)
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {  },
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.Beige)
                ),
                shape = RoundedCornerShape(9.dp),
                enabled = country.value.isNotEmpty() && mDate.value.isNotEmpty()
            ) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )

            }


        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTextFields(string1: String, string2: String, state: MutableState<String>, modifier: Modifier = Modifier) {
    var isExpanded by remember {
        mutableStateOf(false)
    }



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = string1,
            modifier = Modifier.padding(horizontal = 32.dp),
            fontSize = 16.sp,
            color = colorResource(id = R.color.Gray_G700),
            fontWeight = FontWeight.W400,
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            OutlinedTextField(
                value = state.value,
                onValueChange = {},
                readOnly = true,
                placeholder = {
                    Text(
                        text = string2,
                        color = colorResource(id = R.color.Gray_G70)
                    )
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .background(color = Color.White)
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("US") },
                    onClick = {
                        state.value = "US"
                        isExpanded = false
                    },
                    modifier = modifier.background(color = Color.White)
                )
                DropdownMenuItem(
                    text = { Text("UK") },
                    onClick = {
                        state.value = "UK"
                        isExpanded = false
                    },
                    modifier = modifier.background(color = Color.White)
                )
                DropdownMenuItem(
                    text = { Text("Egypt") },
                    onClick = {
                        state.value = "Egypt"
                        isExpanded = false

                    },
                    modifier = modifier.background(color = Color.White)
                )
            }
        }
    }
}


@Composable
fun DatePickerButton(mDate: MutableState<String>) {


    val mContext = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int


    val mCalendar = Calendar.getInstance()


    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()




    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Date Of Birth",
            modifier = Modifier.padding(horizontal = 32.dp),
            fontSize = 16.sp,
            color = colorResource(id = R.color.Gray_G700),
            fontWeight = FontWeight.W400,

            )



        Button(
            onClick = {
                mDatePickerDialog.show()

            },
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .border(1.dp, Color.DarkGray, shape = RoundedCornerShape(4.dp))
                .background(color = Color.White),
            colors = ButtonDefaults.buttonColors(Color.White),

            ) {
            Text(
                text = if(mDate.value.isNotEmpty()) mDate.value else "DD/MM/YYYY",
                color = colorResource(id = R.color.Gray_G70),
                fontSize = 16.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                tint = Color.DarkGray,

                )
        }


    }
}


@Composable
fun BottomSheet(){

}


@Preview(device = "id:pixel_6a")
@Composable
fun OverAll5() {
    SignUpScreen2(rememberNavController())
}