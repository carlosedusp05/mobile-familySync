package com.aulasandroid.familysync.features.editar_lista

import android.util.Log
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.ItemEdition
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.OutlinedCreme
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.features.editar_lista.model.TelaEditarListaViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaEditarLista(
    navController: NavController,
    idLista: Int,
    viewModel: TelaEditarListaViewModel = viewModel()
) {
    if (viewModel.carregando.value) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(branco),
            contentAlignment = Alignment.Center
        ) {

            CircularProgressIndicator(
                color = laranja
            )
        }

        return
    }

    LaunchedEffect(idLista) {
        Log.d("API_FAMILY", "ID QUE CHEGOU NA TELA = $idLista")
        viewModel.carregarLista(idLista)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(branco),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        RowBack(navController, "editar-lista")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.90f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Editar Itens",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro
                )
            }

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
                        .height(25.dp)
                        .padding(start = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Nome do item",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = laranjaEscuro,
                    )
                }

                Row(
                    modifier = Modifier.width(353.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    OutlinedMenorDp(
                        placeHolder = "",
                        width = 200.dp,
                        height = 45.dp,
                        value = viewModel.nomeItem.value,
                        onValueChange = {
                            viewModel.alterarNomeItem(it)
                        }
                    )

                    OrangeButton(
                        modifier = Modifier,
                        text = "Adicionar",
                        width = 140.dp,
                        height = 45.dp,
                        fontSize = 16,
                        navController,
                        "",
                        onClick = {
                            viewModel.adicionarItemTemporario()
                        }
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Tornar lista de compras",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = marrom
                )

                Row(
                    modifier = Modifier
                        .width(353.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(marrom)
                        .padding(start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape)
                            .background(
                                if (viewModel.usarPreco.value)
                                    laranja
                                else
                                    Color.Transparent
                            )
                            .clickable {
                                viewModel.alternarUsarPreco()
                            },
                        contentAlignment = Alignment.Center
                    ) {}

                    OutlinedCreme(
                        value = viewModel.precoItem.value,
                        onValueChange = {
                            viewModel.alterarPreco(it)
                        },
                        placeholder = "R$0,00",
                        modifier = Modifier.width(130.dp),
                        enabled = viewModel.usarPreco.value
                    )

                    OutlinedCreme(
                        value = viewModel.quantidadeItem.value,
                        onValueChange = {
                            viewModel.alterarQuantidade(it)
                        },
                        placeholder = "0",
                        modifier = Modifier.width(70.dp),
                        enabled = viewModel.usarPreco.value
                    )
                }
            }

            Column(
                modifier = Modifier
                    .width(353.dp)
                    .height(320.dp)
                    .clip(RoundedCornerShape(15))
                    .border(4.dp, marrom, RoundedCornerShape(15))
                    .background(creme)
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(vertical = 15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                viewModel.itensLista.forEach { item ->

                    ItemEdition(
                        nome = item.nome_item,
                        precoUnitario = item.valor_unitario.toDoubleOrNull() ?: 0.0,
                        quantidade = item.quantidade,
                        onDelete = {
                            viewModel.removerItem(item)
                        }
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CremeButton(
                    modifier = Modifier,
                    text = "Cancelar",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 22,
                    navController,
                    "",
                    {
                        navController.popBackStack()
                    }
                )

                OrangeButton(
                    modifier = Modifier,
                    text = "Salvar",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 21,
                    navController,
                    "",
                    onClick = {
                        viewModel.salvarLista {
                            navController.popBackStack()
                        }
                    }
                )
            }
        }

        Footer(navController, "lista")
    }
}