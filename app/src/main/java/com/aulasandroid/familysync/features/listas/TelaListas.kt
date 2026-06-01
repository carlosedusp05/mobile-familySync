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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.List
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.features.listas.model.TelaListasViewModel
import com.aulasandroid.familysync.ui.theme.branco

@Composable
fun TelaListas(
    navController: NavController,
    viewModel: TelaListasViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.buscarListas()
    }
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
                            navController.navigate("criar-lista")
                    }
                )
            }

        }

        Footer(navController, "lista")
    }
}