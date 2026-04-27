package com.aulasandroid.familysync.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun Notification() {
    Card(
        modifier = Modifier
            .width(380.dp)
            .height(140.dp),
                colors = CardDefaults.cardColors(
                containerColor = creme
                ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .height(25.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "tema da notificação",
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro,
                    fontSize = 20.sp
                )
            }

            Row(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "xsadsccccccadddccccccccczxnhcsb cguggcfdvbhdbbvchx hvc xvchjxb chhjvccccccccccccccccccccccccccccccccccccc hcx bhjjjjhb chb hjjjjjj chhcbbhdhbvbfhdvbvfhabhdfbvhjb cdsacsda",
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 1.2.em,
                    color = laranjaEscuro,
                    fontSize = 12.sp
                )
            }

            Row(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "18 nov 2026",
                    color = laranja,
                    fontSize = 15.sp
                )
            }
        }
    }
}