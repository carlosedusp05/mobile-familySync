package com.aulasandroid.familysync.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun Footer(
    navController: NavController,
    abaAtiva: String
) {
    var corFundoCalendario = laranjaEscuro
    var corFundoLista = laranjaEscuro
    var corFundoDespesa = laranjaEscuro
    var corFundoGerenciar = laranjaEscuro
    var corFundoInformacao = laranjaEscuro

    when(abaAtiva) {
        "calendario"    -> corFundoCalendario = laranja
        "lista"         -> corFundoLista = laranja
        "despesa"       -> corFundoDespesa = laranja
        "gerenciar"     -> corFundoGerenciar = laranja
        "informacao"    -> corFundoInformacao = laranja
        else            -> laranjaEscuro
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(laranjaEscuro)
            .padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(corFundoLista),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier .size(55.dp),
                onClick = {
                    navController.navigate("lista")
                }
            )  {
                Image(
                    painter = painterResource(R.drawable.list),
                    contentDescription = "logo",
                    colorFilter = ColorFilter.tint(branco),
                    modifier = Modifier .fillMaxSize()
                )
            }
        }

        Row(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(corFundoCalendario),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier .size(55.dp),
                onClick = {
                    navController.navigate("calendario")
                }
            )  {
                Image(
                    painter = painterResource(R.drawable.calendar),
                    contentDescription = "logo",
                    colorFilter = ColorFilter.tint(branco),
                    modifier = Modifier .fillMaxSize()
                )
            }
        }

        Row(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(corFundoGerenciar),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier .size(55.dp),
                onClick = {
                    navController.navigate("gerenciador_familiar")
                }
            )  {
                Image(
                    painter = painterResource(R.drawable.settings),
                    contentDescription = "logo",
                    colorFilter = ColorFilter.tint(branco),
                    modifier = Modifier .fillMaxSize()
                )
            }
        }

        Row(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(corFundoDespesa),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

        ) {
            IconButton(
                modifier = Modifier .size(55.dp),
                onClick = {
                    navController.navigate("despesas")
                }
            )  {
                Image(
                    painter = painterResource(R.drawable.money_pig),
                    contentDescription = "logo",
                    colorFilter = ColorFilter.tint(branco),
                    modifier = Modifier .fillMaxSize()
                )
            }
        }

        Row(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(corFundoInformacao),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier .size(55.dp),
                onClick = {
                    navController.navigate("informacoes_familiar")
                }
            )  {
                Image(
                    painter = painterResource(R.drawable.info),
                    contentDescription = "logo",
                    colorFilter = ColorFilter.tint(branco),
                    modifier = Modifier .fillMaxSize()
                )
            }
        }

    }
}