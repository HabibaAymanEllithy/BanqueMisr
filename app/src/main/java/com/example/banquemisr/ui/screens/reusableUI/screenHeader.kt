package com.example.banquemisr.ui.screens.reusableUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisr.R

@Preview
@Composable
fun ScreenHeader(headerText: String = "khjznn", onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Absolute.spacedBy(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onClick() }, modifier = Modifier.padding(8.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )
        }
        Text(text = headerText, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}