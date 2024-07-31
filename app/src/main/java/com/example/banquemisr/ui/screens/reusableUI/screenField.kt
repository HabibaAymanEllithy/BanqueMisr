package com.example.banquemisr.ui.screens.reusableUI

import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisr.R
import com.example.banquemisr.ui.screens.profileScreen.color

@Preview
@Composable
fun ScreenField(
    headLine: String = "",
    supportingText: String = "",
    leadingIcon: Int = 0,
    trailingIcon: Int = R.drawable.next
) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
        //.clickable {  }
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color(0xFFccced3))
                    .size(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = headLine, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = supportingText, color = Color.Gray, fontSize = 14.sp)
            }
        }
        Icon(
            painter = painterResource(id = trailingIcon),
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )

    }
}

