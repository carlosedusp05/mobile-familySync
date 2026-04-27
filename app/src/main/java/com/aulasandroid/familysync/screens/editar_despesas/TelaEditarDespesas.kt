package com.aulasandroid.familysync.screens.editar_despesas

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.HeaderDespesas
import com.aulasandroid.familysync.components.IconDespesas
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaEditarDespesas(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
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
                    onClick = {/* TODO */},
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
                    text = "Editar Despesas",
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
                .fillMaxHeight(0.7f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Outilined(
                    modifier = Modifier,
                    "",
                    80.dp,
                    50.dp
                )

                Spacer(modifier = Modifier .width(10.dp))

                Text(
                    text = "BRL",
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = laranja
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Outilined(
                    modifier = Modifier,
                    "Mercado",
                    383.dp,
                    52.dp
                )
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconDespesas(R.drawable.shopping)
                    IconDespesas(R.drawable.light)
                    IconDespesas(R.drawable.water)
                    IconDespesas(R.drawable.home)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconDespesas(R.drawable.book)
                    IconDespesas(R.drawable.heart)
                    IconDespesas(R.drawable.meal)
                    IconDespesas(R.drawable.party)
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Button(
                    onClick = {/* TODO */},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = laranjaEscuro
                    ),
                    shape = RoundedCornerShape(40),
                    modifier = Modifier .width(150.dp) .height(55.dp)
                ){
                    Text(
                        text = "Confirmar",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp
                    )
                }
            }
        }

        Footer()
    }
}