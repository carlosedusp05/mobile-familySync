package com.aulasandroid.familysync.features.eventos

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Event
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.OutlinedPopUp
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.features.eventos.function.formatarData
import com.aulasandroid.familysync.features.eventos.model.TelaEventosViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun TelaEventos(
    navController: NavController,
    viewModel: TelaEventosViewModel = viewModel()
) {

    var mostrarPopup by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        RowBack(navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Text(
                text = "MEUS EVENTOS",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = laranja
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                viewModel.listaEventos.forEach { evento ->

                    Event(
                        navController = navController,
                        titulo = evento.titulo,
                        descricao = evento.descricao,
                        data = formatarData(evento.data),
                        horario = evento.hora.substring(0, 5),
                        criador = viewModel.buscarNomeUsuario(evento.id_usuario),
                        onClick = {
                            mostrarPopup = true
                        }
                    )
                }
            }
        }

        Footer(navController, "")

        if (mostrarPopup) {
            Dialog(onDismissRequest = { mostrarPopup = false }) {
                Card(
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = branco
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(30.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row(
                            modifier = Modifier
                                .width(200.dp)
                                .height(35.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "DATA:",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = laranjaEscuro
                            )

                            OutlinedMenorDp(
                                "Ex: 01-01-01",
                                130.dp,
                                30.dp,
                                "",
                                {}
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedMenorDp(
                                "Nome",
                                170.dp,
                                35.dp,
                                "",
                                {}
                            )

                            OutlinedMenorDp(
                                "20:00",
                                80.dp,
                                30.dp,
                                "",
                                {}
                            )
                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            OutlinedPopUp(
                                placeHolder = "Descrição",
                                width = 285.dp,
                                height = 140.dp,
                                ""
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CremeButtonPopUp(
                                "Cancelar",
                                {mostrarPopup = false}
                            )

                            OrangeButtonPopUp(
                                "Salvar",
                                {mostrarPopup = false}
                            )

                        }
                    }
                }
            }
        }
    }
}