package com.aulasandroid.familysync.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.CardFunctionality
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaHome(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Header()
        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Nome da família",
                color = marrom,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
        Column(
            modifier = Modifier
                .height(500.dp)
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CardFunctionality(
                    140.dp,
                    150.dp,
                    "Lista compartilhada",
                    R.drawable.list
                )

                CardFunctionality(
                    140.dp,
                    150.dp,
                    "Calendário de eventos",
                    R.drawable.calendar
                )
            }
            Row(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CardFunctionality(
                    140.dp,
                    150.dp,
                    "Gerenciamento financeiro",
                    R.drawable.money_pig
                )

                CardFunctionality(
                    140.dp,
                    150.dp,
                    "Informações da família",
                    R.drawable.info,
                    70.dp
                )
            }
            Row(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .width(355.dp)
                        .height(140.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = creme
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.settings),
                            contentDescription = " icon da Gerenciar Família",
                            modifier = Modifier.size(75.dp),
                            tint = laranja
                        )

                        Spacer(modifier = Modifier .height(5.dp))

                        Text(
                            text = "Gerenciar Família",
                            color = Color.Black,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}