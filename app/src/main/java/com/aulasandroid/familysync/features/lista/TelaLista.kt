package com.aulasandroid.familysync.features.lista

import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Item
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.features.lista.model.TelaListaViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaLista(
    navController: NavController,
    idLista: Int,
    viewModel: TelaListaViewModel =  androidx.lifecycle.viewmodel.compose.viewModel()
) {

    var mostrarPopup by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {

        viewModel.buscarItens(idLista)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(branco),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
       RowBack(navController, "lista")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = viewModel.nomeOriginalLista.value,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro
                )

                IconButton(
                    onClick = {viewModel.abrirPopupEdicao()
                              mostrarPopup = true
                              },
                    modifier = Modifier.size(50.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.pencil),
                        tint = laranjaEscuro,
                        contentDescription = "icon apagar",
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = viewModel.participantes.value,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OrangeButton(
                    modifier = Modifier,
                    text = "editar itens",
                    width = 160.dp,
                    height = 33.dp,
                    fontSize = 14,
                    navController,
                    "",
                    {navController.navigate("editar-lista/$idLista") },
                )

                if (viewModel.todosSelecionados()) {
                    OrangeButton(
                        modifier = Modifier,
                        text = "desmarcar todos",
                        width = 160.dp,
                        height = 33.dp,
                        fontSize = 12,
                        navController,
                        "lista",
                        {
                            viewModel.alterarTodosItens()
                        }
                    )
                } else {
                    CremeButton(
                        modifier = Modifier,
                        text = "marcar todos",
                        width = 160.dp,
                        height = 33.dp,
                        fontSize = 14,
                        navController,
                        "lista",
                        {
                            viewModel.alterarTodosItens()
                        }
                    )
                }
            }
                if (viewModel.listaProdutos.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.98f)
                            .background(creme)
                            .padding(vertical = 15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Lista vazia.\nClique em \"editar itens\" para adicioná-los.",
                            textAlign = TextAlign.Center,
                            color = marrom,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.98f)
                            .background(creme)
                            .verticalScroll(rememberScrollState())
                            .imePadding()
                            .padding(vertical = 15.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                    viewModel.listaProdutos.forEach { produto ->

                        Item(
                            nome = produto.nome_item,
                            precoUnitario = viewModel.obterPrecoUnitarioFormatado(produto),
                            quantidade = produto.quantidade,
                            precoTotal = viewModel.obterPrecoTotalFormatado(produto),
                            listaCompra = viewModel.obterPrecoUnitario(produto) > 0,
                            isChecked = produto.comprado == 1,
                            onCheckChange = { checked ->
                                viewModel.atualizarItemComprado(
                                    produto,
                                    checked
                                )
                            }
                        )
                    }
                }
            }
        }

        Footer(navController, "lista")
    }

    if (mostrarPopup) {
        Dialog(onDismissRequest = { mostrarPopup = false }) {
            Card(
                modifier = Modifier
                    .width(350.dp)
                    .height(320.dp),
                colors = CardDefaults.cardColors(
                    containerColor = branco
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(30.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(25.dp)
                            .padding(start = 30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Alterar tema da Lista",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = marrom,
                            textAlign = TextAlign.Center
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
                            placeHolder = "",
                            value = viewModel.nomeLista.value,
                            onValueChange = {
                                viewModel.alterarNomeLista(it)
                            },
                            width = 353.dp,
                            height = 45.dp
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
                            {
                                viewModel.salvarNomeLista()
                                mostrarPopup = false
                            }
                        )
                    }

                }
            }
        }
    }
}