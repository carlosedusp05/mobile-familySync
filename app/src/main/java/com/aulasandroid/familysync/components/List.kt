package com.aulasandroid.familysync.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom
import com.aulasandroid.familysync.ui.theme.vermelho
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

@Composable
fun List(
    navController: NavController,
    idLista: Int,
    criador: String,
    nome: String,
    porcentagem: Int,
    favorita: Boolean,
    onFavoritoChange: (Boolean) -> Unit,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier
            .width(380.dp)
            .height(120.dp)
            .clickable(
                onClick = {
                    navController.navigate("lista/$idLista")
                },
            ),
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
                    .height(35.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(200.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = nome,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = laranjaEscuro
                    )

                    if (favorita) {

                        Icon(
                            modifier = Modifier
                                .size(25.dp)
                                .clickable {

                                    onFavoritoChange(false)
                                },
                            imageVector = Icons.Default.Favorite,
                            tint = vermelhoEscuro,
                            contentDescription = "Favorite icon"
                        )

                    } else {

                        Icon(
                            modifier = Modifier
                                .size(25.dp)
                                .clickable {

                                    onFavoritoChange(true)
                                },
                            imageVector = Icons.Default.FavoriteBorder,
                            tint = vermelhoEscuro,
                            contentDescription = "Favorite border icon"
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(vermelho),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    IconButton(
                        onClick = {
                            onDelete()
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.trash),
                            tint = branco,
                            contentDescription = "icon apagar",
                            modifier = Modifier.fillMaxSize(0.8f)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .fillMaxHeight()
                            .border(
                                width = 2.dp,
                                color = marrom,
                                shape = RoundedCornerShape(50.dp)
                            )
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(
                                    porcentagem / 100f
                                )
                                .background(
                                    color = marrom,
                                    shape = RoundedCornerShape(50.dp)
                                )
                        ) {}
                    }

                    Text(
                        text = "$porcentagem%",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = marrom,
                        textAlign = TextAlign.Center
                    )
                }

                Row(
                    modifier = Modifier
                        .width(140.dp)
                        .height(20.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(laranjaEscuro),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Criado por $criador",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = branco
                    )
                }
            }
        }
    }
}