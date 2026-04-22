package com.aulasandroid.familysync.components

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun CardFunctionality(
    height: Dp,
    width: Dp,
    nome: String,
    iconId: Int,
    sizeIcon: Dp = 55.dp
) {
    Card(
        modifier = Modifier
            .width(width)
            .height(height),
        colors = CardDefaults.cardColors(
            containerColor = creme
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(iconId),
                contentDescription = " icon da $nome",
                modifier = Modifier.size(sizeIcon),
                tint = laranja
            )

            Text(
                text = nome,
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}