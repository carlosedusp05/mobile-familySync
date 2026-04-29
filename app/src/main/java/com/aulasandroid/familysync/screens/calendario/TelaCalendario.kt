package com.aulasandroid.familysync.screens.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.components.Event
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun TelaCalendario(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "CALENDÁRIO",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro
                )
            }
            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(300.dp),
                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(creme)

                ) { }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Eventos marcados:",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(bottom = 15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Event()
                Event()
                Event()
                Event()
            }
        }

        Footer()
    }
}