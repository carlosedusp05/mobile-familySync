package com.aulasandroid.familysync.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

//@Composable
//fun Expences(navController: NavController, gasto: String, cor: Color) {
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(50.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(250.dp)
//                .clip(RoundedCornerShape(15.dp))
//                .border(3.dp, laranja, RoundedCornerShape(15.dp))
//                .background(branco),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(35.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Icon(
//                    painter = painterResource(R.drawable.meal),
//                    contentDescription = "seta-de-voltar",
//                    tint = cor,
//                    modifier = Modifier .size(35.dp)
//                )
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(75.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = gasto,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 12.sp,
//                    color = Color.Black
//                )
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(30.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "60%",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 12.sp,
//                    color = Color.Black
//                )
//            }
//
//            Column(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(70.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "R$ 5000",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 12.sp,
//                    color = Color.Black
//                )
//            }
//        }
//
//        IconButton(
//            modifier = Modifier .size(45.dp),
//            onClick = {navController.navigate("editar_despesas")}
//        )  {
//            Image(
//                painter = painterResource(R.drawable.pencil),
//                contentDescription = "editar",
//                colorFilter = ColorFilter.tint(laranjaEscuro),
//                modifier = Modifier .fillMaxSize()
//            )
//        }
//
//        IconButton(
//            modifier = Modifier .size(45.dp),
//            onClick = {navController.navigate("despesas")}
//        )  {
//            Image(
//                painter = painterResource(R.drawable.trash),
//                contentDescription = "excluir",
//                colorFilter = ColorFilter.tint(laranjaEscuro),
//                modifier = Modifier .fillMaxSize()
//            )
//        }
//    }
//}

@Composable
fun Expences(
    navController: NavController,
    gasto: String,            // Nome/Descrição (Ex: "Mercado")
    iconeEmoji: String,       // Ícone vindo da API (Ex: "🛒")
    porcentagem: String,      // String calculada (Ex: "24%")
    valor: String,            // Valor formatado (Ex: "R$ 1200,00")
    corBorda: Color = laranja // Mantém sua cor padrão de borda
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .width(250.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(3.dp, corBorda, RoundedCornerShape(15.dp))
                .background(branco),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Coluna do Ícone (Alterado para Text para renderizar o Emoji da API)
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(35.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = iconeEmoji,
                    fontSize = 20.sp
                )
            }

            // Coluna do Título da Despesa
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(75.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = gasto,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }

            // Coluna da Porcentagem Dinâmica
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = porcentagem, // Valor calculado passado por parâmetro
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }

            // Coluna do Valor Monetário Real
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(70.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = valor, // Valor formatado vindo do ViewModel
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }

        IconButton(
            modifier = Modifier.size(45.dp),
            onClick = { navController.navigate("editar_despesas") }
        ) {
            Image(
                painter = painterResource(R.drawable.pencil),
                contentDescription = "editar",
                colorFilter = ColorFilter.tint(laranjaEscuro),
                modifier = Modifier.fillMaxSize()
            )
        }

        IconButton(
            modifier = Modifier.size(45.dp),
            onClick = { navController.navigate("despesas") }
        ) {
            Image(
                painter = painterResource(R.drawable.trash),
                contentDescription = "excluir",
                colorFilter = ColorFilter.tint(laranjaEscuro),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}