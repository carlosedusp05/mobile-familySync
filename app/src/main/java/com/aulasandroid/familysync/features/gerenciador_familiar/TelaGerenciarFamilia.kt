package com.aulasandroid.familysync.features.gerenciador_familiar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.AddButton
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Family
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.Member
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.OutlinedPopUp
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaGerenciarFamilia(navController: NavController) {

    var mostrarPopup by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Header(navController)

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
//                    Outilined(
//                        modifier = Modifier,
//                        "Nome da família",
//                        383.dp,
//                        52.dp
//                    )
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
                            AddButton(35.dp, navController, "", { mostrarPopup = true})
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
                        onClick = {navController.navigate("alterar_endereco")}
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
                        21,
                        navController,
                        "gerenciador_familiar"
                    )
                }
            }
        }

        Footer(navController, "gerenciar")

        if (mostrarPopup) {
            Dialog(onDismissRequest = { mostrarPopup = false }) {
                Card(
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .background(branco)
                            .padding(30.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                    ) {

                        Text(
                            text = "ADICIONAR MEMBRO",
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold,
                            color = marrom
                        )

                        OutlinedPopUp(
                            "Grau de parentesco",
                            155.dp,
                            52.dp,
                            ""
                        )

                        OutlinedPopUp(
                            "Nome do usuário",
                            280.dp,
                            52.dp,
                            ""
                        )

                        Row(
                            modifier = Modifier
                                .width(280.dp)
                                .height(42.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CremeButtonPopUp(
                                "Cancelar",
                                {mostrarPopup = false}
                            )

                            OrangeButtonPopUp(
                                "Adicionar",
                                {mostrarPopup = false}
                            )

                        }
                    }
                }
            }
        }
    }
}