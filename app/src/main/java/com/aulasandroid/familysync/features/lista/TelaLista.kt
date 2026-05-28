package com.aulasandroid.familysync.features.lista

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Item
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.features.lista.model.TelaListaViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun TelaLista(
    navController: NavController,
    idLista: Int,
    viewModel: TelaListaViewModel =  androidx.lifecycle.viewmodel.compose.viewModel()
) {
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
       RowBack(navController)

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
                    text = viewModel.nomeLista.value,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro
                )
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
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CremeButton(
                    modifier = Modifier,
                    text = "selecionar todos",
                    width = 160.dp,
                    height = 33.dp,
                    fontSize = 14,
                    navController,
                    "lista",
                    {}
                )

                IconButton(
                    onClick = {navController.navigate("editar-lista") },
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
                        navController = navController,
                        nome = produto.nomeItem,
                        precoUnitario =
                            produto.valorUnitario.toDouble(),
                        quantidade = produto.quantidade,
                        isChecked = produto.comprado == 1,
                        onCheckChange = {}
                    )
                }
            }
        }

        Footer(navController, "lista")
    }
}