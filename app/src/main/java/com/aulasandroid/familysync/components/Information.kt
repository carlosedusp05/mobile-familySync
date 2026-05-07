package com.aulasandroid.familysync.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun Information(
    tema: String,
    conteudo: String,
    navController: NavController,
    onClick: () -> Unit
) {
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(130.dp)
                        .background(marrom),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = tema,
                        fontWeight = FontWeight.Bold,
                        color = branco,
                        fontSize = 14.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(70.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(
                        modifier = Modifier .size(25.dp),
                        onClick = { onClick() }
                    )  {
                        Image(
                            painter = painterResource(com.aulasandroid.familysync.R.drawable.pencil),
                            contentDescription = "editar",
                            colorFilter = ColorFilter.tint(marrom),
                            modifier = Modifier .fillMaxSize()
                        )
                    }

                    IconButton(
                        modifier = Modifier .size(25.dp),
                        onClick = {navController.navigate("informacoes_familiar")}
                    )  {
                        Image(
                            painter = painterResource(com.aulasandroid.familysync.R.drawable.trash),
                            contentDescription = "apagar",
                            colorFilter = ColorFilter.tint(marrom),
                            modifier = Modifier .fillMaxSize()
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .height(95.dp)
                    .fillMaxWidth()
                    .padding(7.dp)

            ) {
                Text(
                    text = conteudo,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 1.2.em,
                    color = marrom,
                    fontSize = 12.sp
                )
            }
        }
    }
}