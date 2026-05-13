package com.aulasandroid.familysync.features.lista

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.Item
import com.aulasandroid.familysync.components.List
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

@Composable
fun TelaLista(navController: NavController) {
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
                    text = "Nome da Lista",
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
                    text = "Fulano, pedro, paulo, joao, rafael ...",
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
                    "lista"
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
                Item(
                    navController,
                    "farinha",
                    23.00,
                    4
                )

                Item(
                    navController,
                    "suco",
                    1.50,
                    9
                )

                Item(
                    navController,
                    "Arroz 10Kg",
                    73.00,
                    1
                )

                Item(
                    navController,
                    "caldo de cana",
                    13.00,
                    2
                )

                Item(
                    navController,
                    "bola",
                    42.50,
                    1
                )

                Item(
                    navController,
                    "azeite",
                    53.00,
                    1
                )

                Item(
                    navController,
                    "feijao",
                    13.00,
                    3
                )

                Item(
                    navController,
                    "azeite",
                    53.00,
                    1
                )

                Item(
                    navController,
                    "feijao",
                    13.00,
                    3
                )

                Item(
                    navController,
                    "feijao",
                    13.00,
                    3
                )

                Item(
                    navController,
                    "azeite",
                    53.00,
                    1
                )

                Item(
                    navController,
                    "feijao",
                    13.00,
                    3
                )
            }
        }

        Footer(navController, "lista")
    }
}