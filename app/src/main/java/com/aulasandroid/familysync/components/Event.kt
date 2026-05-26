package com.aulasandroid.familysync.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom
import com.aulasandroid.familysync.ui.theme.vermelho

@Composable
fun Event(
    navController: NavController,
    id: Int,
    titulo: String,
    descricao: String,
    data: String,
    horario: String,
    criador: String ,
    onClick: () -> Unit,
    onDelete: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .width(360.dp)
            .height(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = creme
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
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
                        .width(140.dp)
                        .background(marrom)
                        .padding(start = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = titulo,
                        fontWeight = FontWeight.Bold,
                        color = branco,
                        fontSize = 14.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(160.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = data,
                        fontWeight = FontWeight.Bold,
                        color = marrom,
                        fontSize = 14.sp
                    )

                    Text(
                        text = horario,
                        fontWeight = FontWeight.Bold,
                        color = marrom,
                        fontSize = 14.sp
                    )
                }
            }

                Row(
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .padding(7.dp)
                ) {
                    Text(
                        text = descricao,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 1.2.em,
                        color = laranjaEscuro,
                        fontSize = 12.sp
                    )
                }

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
                            .width(140.dp)
                            .padding(start = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Created by $criador",
                            color = marrom,
                            fontSize = 12.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(90.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(
                            modifier = Modifier .size(25.dp),
                            onClick = { onClick()}
                        )  {
                            Image(
                                painter = painterResource(com.aulasandroid.familysync.R.drawable.pencil),
                                contentDescription = "editar",
                                colorFilter = ColorFilter.tint(marrom),
                                modifier = Modifier .fillMaxSize()
                            )
                        }

                        IconButton(
                            modifier = Modifier.size(25.dp),
                            onClick = {
                                onDelete(id)
                            }
                        ) {
                            Image(
                                painter = painterResource(
                                    com.aulasandroid.familysync.R.drawable.trash
                                ),
                                contentDescription = "apagar",
                                colorFilter = ColorFilter.tint(marrom),
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
}