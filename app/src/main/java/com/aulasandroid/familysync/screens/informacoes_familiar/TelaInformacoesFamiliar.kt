package com.aulasandroid.familysync.screens.informacoes_familiar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun TelaInformacoesFamiliar(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8F),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Informações familiar",
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = laranja
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.Red),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

            }
        }

        Footer()
    }
}