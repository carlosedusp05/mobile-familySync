package com.aulasandroid.familysync.features.financas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.AddButton
import com.aulasandroid.familysync.components.Expences
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Graphic
import com.aulasandroid.familysync.features.financas.function.gerarCor
import com.aulasandroid.familysync.features.financas.model.Periodo
import com.aulasandroid.familysync.features.financas.model.TelaFinancasViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaFinancas(
    navController: NavController,
    viewModel: TelaFinancasViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.carregarDados()
    }

    val periodoSelecionado =
        viewModel.periodoSelecionado

    if (viewModel.carregando) {

        Column(
            modifier = Modifier.fillMaxSize()
                .background(branco),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            CircularProgressIndicator(
                color = laranja
            )
        }

        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                    .background(marrom)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        onClick = { navController.navigate("home") },
                        colors = ButtonDefaults.buttonColors(containerColor = laranja),
                        shape = RoundedCornerShape(100),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow),
                            contentDescription = "seta-de-voltar",
                            tint = marrom,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().height(30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Total gasto",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth().height(30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = viewModel.totalGastoFormatado,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .height(330.dp)
                    .width(350.dp)
                    .offset(y = -40.dp),
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(containerColor = branco),
                elevation = CardDefaults.cardElevation(4.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        val periodos = listOf(
                            Periodo.DIA,
                            Periodo.SEMANA,
                            Periodo.MES,
                            Periodo.ANO
                        )
                        periodos.forEach { periodo ->

                            val estaSelecionado =
                                periodoSelecionado == periodo

                            TextButton(
                                onClick = {
                                    viewModel.carregarPeriodo(periodo)
                                }
                            ) {

                                Text(
                                    text = when(periodo) {
                                        Periodo.DIA -> "Dia"
                                        Periodo.SEMANA -> "Semana"
                                        Periodo.MES -> "Mês"
                                        Periodo.ANO -> "Ano"
                                    },
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = laranjaEscuro,
                                    textDecoration =
                                        if (estaSelecionado)
                                            TextDecoration.Underline
                                        else
                                            TextDecoration.None
                                )
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(245.dp)
                        .padding(start = 60.dp, end = 10.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxHeight().width(210.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        val listaCores =
                            viewModel.listaItensTela.mapIndexed { index, _ ->
                                gerarCor(index)
                            }

                        val valoresFatias =
                            viewModel.listaItensTela.map {
                                it.valor.toFloatOrNull() ?: 0f
                            }

                        Graphic(
                            fatias = valoresFatias,
                            cores = listaCores
                        )
                    }

                    AddButton(45.dp, navController, "despesas")
                }
            }

            Column(
                modifier = Modifier
                    .width(350.dp)
                    .height(250.dp)
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                viewModel.listaItensTela.forEachIndexed { index, item ->

                    val corItem = gerarCor(index)

                    Expences(
                        navController = navController,
                        gasto = item.titulo,
                        iconeEmoji = item.icone,
                        porcentagem = "",
                        valor = "R$ ${item.valor}",
                        corBorda = corItem,
                        idFinanca = item.id,
                        onDelete = {viewModel.deletarFinanca(item.id)}
                    )
                }
            }
        }
        Footer(navController, "despesa")
    }
}