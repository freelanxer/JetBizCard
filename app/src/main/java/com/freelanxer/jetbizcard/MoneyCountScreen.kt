package com.freelanxer.jetbizcard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MoneyCountScreen() {
    val count = remember {
        mutableStateOf(0)
    }
    val money = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Saved money: $ ${money.value}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                style = moneyTextStyle(money.value)
            )
            Spacer(modifier = Modifier.height(26.dp))
            MoneyCountButton(count.value) { newCount ->
                count.value = newCount
                money.value += 10;
            }
        }
    }
}

@Composable
private fun MoneyCountButton(
    count: Int = 0,
    onClicked: (Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable {
                onClicked(count + 1)
            },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Tap $count", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

    }
}

fun moneyTextStyle(money: Int) =
    if (money >= 100)
        TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Magenta, Color.Blue)
            )
        )
    else TextStyle()
