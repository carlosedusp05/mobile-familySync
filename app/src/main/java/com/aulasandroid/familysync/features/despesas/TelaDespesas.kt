package com.aulasandroid.familysync.features.despesas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.aulasandroid.familysync.features.despesas.function.gerarCor
import com.aulasandroid.familysync.features.despesas.model.TelaDespesasViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

//@Composable
//fun TelaDespesas(navController: NavController) {
//
//    var periodoSelecionado by remember {
//        mutableStateOf("Dia")
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(branco),
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.9f),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(170.dp)
//                    .clip(
//                        RoundedCornerShape(
//                            bottomEnd = 20.dp,
//                            bottomStart = 20.dp
//                        )
//                    )
//                    .background(marrom)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp)
//                        .padding(horizontal = 25.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                ) {
//                    Button(
//                        onClick = {
//                            navController.popBackStack()
//                        },
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = laranja
//                        ),
//                        shape = RoundedCornerShape(100),
//                        contentPadding = PaddingValues(0.dp),
//                        modifier = Modifier .size(40.dp)
//                    ){
//                        Icon(
//                            painter = painterResource(R.drawable.arrow),
//                            contentDescription = "seta-de-voltar",
//                            tint = marrom,
//                            modifier = Modifier .size(20.dp)
//                        )
//                    }
//                }
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(60.dp),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Row (
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(30.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            text = "Total gasto",
//                            fontWeight = FontWeight.SemiBold,
//                            fontSize = 18.sp,
//                            color = Color.White
//                        )
//                        }
//
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(30.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            text = "R$ 5000",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 21.sp,
//                            color = Color.White
//                        )
//                    }
//                }
//            }
//            Card(
//                modifier = Modifier
//                    .height(330.dp)
//                    .width(350.dp)
//                    .offset(y = -40.dp),
//                shape = RoundedCornerShape(30.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = branco
//                ),
//                elevation = CardDefaults.cardElevation(4.dp),
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(45.dp)
//                        .padding(horizontal = 10.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceEvenly
//                    ) {
//                        val periodos = listOf("Dia", "Semana", "Mês", "Ano")
//
//                        periodos.forEach { periodo ->
//                            val estaSelecionado = periodoSelecionado == periodo
//
//                            TextButton(
//                                onClick = { periodoSelecionado = periodo }
//                            ) {
//                                Text(
//                                    text = periodo,
//                                    fontWeight = FontWeight.SemiBold,
//                                    fontSize = 21.sp,
//                                    color = laranjaEscuro,
//                                    textDecoration = if (estaSelecionado) TextDecoration.Underline else TextDecoration.None
//                                )
//                            }
//                        }
//                    }
//                }
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(35.dp)
//                        .padding(horizontal = 10.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        text = "1 mai - 30 mai",
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 21.sp,
//                        color = laranjaEscuro
//                    )
//                }
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(245.dp)
//                        .padding(start = 60.dp, end = 10.dp),
//                    verticalAlignment = Alignment.Bottom,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//
//                    Row(
//                        modifier = Modifier
//                            .fillMaxHeight()
//                            .width(210.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        val valores = listOf(20f, 35f, 5f, 10f, 10f, 20F)
//                        val listaCores = listOf(laranja,
//                            Color.Blue, laranjaEscuro, Color(0xFFFFCC80), marrom, vermelhoEscuro
//                        )
//
//                        Graphic(
//                            fatias = valores,
//                            cores = listaCores
//                        )
//                    }
//
//                    AddButton(45.dp, navController, "despesas")
//                }
//            }
//            Column(
//                modifier = Modifier
//                    .width(350.dp)
//                    .height(250.dp)
//                    .verticalScroll(rememberScrollState())
//                    .imePadding()
//                    .padding(bottom = 15.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.spacedBy(15.dp)
//            ) {
//                Expences(navController, "Mercado", laranja)
//                Expences(navController, "Comida", Color.Blue)
//                Expences(navController, "Compras", laranjaEscuro)
//                Expences(navController, "passeio", Color(0xFFFFCC80))
//                Expences(navController, "escola", marrom)
//                Expences(navController, "festa", vermelhoEscuro)
//            }
//        }
//        Footer(navController, "despesa")
//    }
//}

@Composable
fun TelaDespesas(
    navController: NavController,
    viewModel: TelaDespesasViewModel = viewModel() // Injeção do ViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.carregarDados()
    }

    var periodoSelecionado by remember { mutableStateOf("Dia") }

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
                        onClick = { navController.popBackStack() },
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
                        val periodos = listOf("Dia", "Semana", "Mês", "Ano")
                        periodos.forEach { periodo ->
                            val estaSelecionado = periodoSelecionado == periodo
                            TextButton(onClick = { periodoSelecionado = periodo }) {
                                Text(
                                    text = periodo,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 21.sp,
                                    color = laranjaEscuro,
                                    textDecoration = if (estaSelecionado) TextDecoration.Underline else TextDecoration.None
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
                    Text(
                        text = "1 mai - 30 mai",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 21.sp,
                        color = laranjaEscuro
                    )
                }

                // Bloco do Gráfico de Pizza
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
                        val valoresFatias = viewModel.listaItensTela.map { it.valorNumerico}

                        val listaCores = valoresFatias.mapIndexed { index, _ -> gerarCor(index) }

                        Graphic(
                            fatias = if (valoresFatias.isEmpty()) listOf(1f) else valoresFatias,
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
                    val corItem = gerarCor(index % 1000)
                    Expences(
                        navController = navController,
                        gasto = item.titulo,
                        iconeEmoji = item.icone,
                        porcentagem = item.porcentagem,
                        valor = item.valorFormatado,
                        corBorda = corItem
                    )
                }
            }
        }
        Footer(navController, "despesa")
    }
}