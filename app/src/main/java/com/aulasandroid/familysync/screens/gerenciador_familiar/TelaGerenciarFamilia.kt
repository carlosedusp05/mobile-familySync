package com.aulasandroid.familysync.screens.gerenciador_familiar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.components.AddButton
import com.aulasandroid.familysync.components.Family
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.Member
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaGerenciarFamilia(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Family(110.dp)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Nome da família",
                        383.dp,
                        52.dp
                    )
                }

                Card(
                    modifier = Modifier
                        .height(330.dp)
                        .width(380.dp),
                    colors = CardDefaults.cardColors(
                            containerColor = creme
                            ),
                    elevation = CardDefaults.cardElevation(4.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(100.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Membros",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = laranja
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(50.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AddButton(35.dp)
                        }
                    }

                    Spacer(modifier  = Modifier .height(20.dp))

                    LazyColumn(
                        modifier = Modifier
                            .height(260.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        item {
                            Member(nome ="Paulo", parentesco = "Filho")
                            Member(nome ="Paulo", parentesco = "Filho")
                            Member(nome ="Paulo", parentesco = "Filho")
                            Member(nome ="Paulo", parentesco = "Filho")
                            Member(nome ="Paulo", parentesco = "Filho")
                        }

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextButton(
                        onClick = {/* TODO */}
                    ) {
                        Text(
                            text = "Alterar endereço?",
                            fontSize = 21.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = laranja,
                            textDecoration = TextDecoration.Underline
                        )
                    }

                    OrangeButton(
                        Modifier,
                        "Salvar",
                        180.dp,
                        50.dp,
                        21
                    )
                }
            }
        }

        Footer()
    }
}