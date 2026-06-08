package com.aulasandroid.familysync.features.adicionar_financas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.features.adicionar_financas.model.CategoriaFinanca
import com.aulasandroid.familysync.features.adicionar_financas.model.TelaAdicionarFinancasViewModel
import com.aulasandroid.familysync.features.adicionar_financas.model.categorias
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaAdicionarFinancas(
    navController: NavController,
    viewModel: TelaAdicionarFinancasViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(
                    bottomEnd = 20.dp,
                    bottomStart = 20.dp
                ))
                .background(marrom)
                .padding(top = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {navController.popBackStack()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = laranja
                    ),
                    shape = RoundedCornerShape(100),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier .size(45.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.arrow),
                        contentDescription = "seta-de-voltar",
                        tint = marrom,
                        modifier = Modifier .size(25.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Adicionar Despesas",
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "tema:",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = laranja
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    OutlinedMenorDp(
                        placeHolder = "tema",
                        width = 220.dp,
                        height = 52.dp,
                        value = viewModel.tema,
                        onValueChange = {
                            viewModel.alterarTema(it)
                        }
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "valor: ",
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = laranja
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    OutlinedMenorDp(
                        placeHolder = "R$ 0,00",
                        width = 100.dp,
                        height = 52.dp,
                        value = viewModel.valor,
                        onValueChange = {
                            viewModel.alterarValor(it)
                        },
                        keyboardType = KeyboardType.Number
                    )
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Categoria",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = laranja
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(285.dp)
                        .padding(horizontal = 12.dp)
                ) {

                    items(categorias.size) { index ->

                        val categoria = categorias[index]

                        val selecionado =
                            viewModel.categoriaSelecionada == categoria

                        Column(
                            modifier = Modifier
                                .padding(6.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    if (selecionado)
                                        laranja
                                    else
                                        Color.White
                                )
                                .border(
                                    width = 1.dp,
                                    color = laranja,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clickable {
                                    viewModel.selecionarCategoria(categoria)
                                }
                                .padding(vertical = 12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = categoria.icon,
                                fontSize = 30.sp
                            )

                            Text(
                                text = categoria.label,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color =
                                    if (selecionado)
                                        Color.White
                                    else
                                        laranjaEscuro
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                OrangeButton(
                    modifier = Modifier,
                    text = "Confirmar",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 21,
                    navController,
                    "",
                    onClick = {
                        viewModel.salvarFinanca(
                            onSuccess = {
                                navController.navigate("despesas")
                            }
                        )
                    }
                )
            }
        }

        Footer(navController, "despesa")
    }
}