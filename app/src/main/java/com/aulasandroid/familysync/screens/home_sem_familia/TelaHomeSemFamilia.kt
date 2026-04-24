package com.aulasandroid.familysync.screens.home_sem_familia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaHomeSemFamilia(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(branco),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Column(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .width(250.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Você não tem ou não pertence a uma família ainda",
                color = marrom,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier .height(15.dp ))

            OrangeButton(
                modifier = Modifier,
                text = "Criar uma família!",
                width = 245.dp,
                height = 55.dp,
                fontSize = 21
            )
        }
    }
}