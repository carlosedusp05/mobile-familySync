package com.aulasandroid.familysync.features.listas

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.List
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.OutlinedDataMenorDp
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.OutlinedPopUp
import com.aulasandroid.familysync.features.listas.model.TelaListasViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaListas(
    navController: NavController,
    viewModel: TelaListasViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.buscarListas()
    }

    var mostrarPopup by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(branco),
        horizontalAlignment = Alignment.CenterHorizontally,
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
                    .fillMaxHeight(0.85f)
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(bottom = 15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                viewModel.listaListas.forEach { lista ->

                    List(
                        navController = navController,
                        idLista = lista.idLista,
                        criador = lista.nomeUsuario,
                        nome = lista.nomeLista,
                        porcentagem = viewModel.calcularPorcentagem(lista),
                        favorita = lista.favorita == 1,
                        onFavoritoChange = { favorito ->

                            viewModel.atualizarFavorita(
                                lista.idLista,
                                favorito
                            )
                        },
                        onDelete = {

                            viewModel.deletarLista(
                                lista.idLista
                            )
                        }
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OrangeButton(
                    modifier = Modifier,
                    text = "criar lista",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 21,
                    navController,
                    "lista",
                    onClick = {
                        mostrarPopup = true
                    }
                )
            }

        }

        Footer(navController, "lista")
    }

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
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Tema da Lista",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = laranjaEscuro,
                            )
                        }
                        OutlinedMenorDp(
                            placeHolder = "Tema da lista",
                            width = 353.dp,
                            height = 40.dp,
                            value = viewModel.nomeLista.value,
                            onValueChange = {

                                viewModel.nomeLista.value = it
                            }
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
                            "Criar",
                            {
                                viewModel.criarLista(
                                    viewModel.nomeLista.value
                                )

                                viewModel.nomeLista.value = ""
                               mostrarPopup = false
                            }
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "* Para adicionar itens a lista você deve cria-la primeiro e depois edta-la para atribuir os itens.",
                            color = marrom,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}