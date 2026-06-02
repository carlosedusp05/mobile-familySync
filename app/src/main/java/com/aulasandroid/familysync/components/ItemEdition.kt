package com.aulasandroid.familysync.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

@Composable
fun ItemEdition(
    nome: String,
    precoUnitario: Double,
    quantidade: Int,
    onDelete: () -> Unit
) {
    val precoTotal = precoUnitario * quantidade

    val mostrarPreco =
        precoUnitario > 0

    Card(
        modifier = Modifier
            .width(330.dp)
            .height(40.dp),
        shape = RoundedCornerShape(35),
        colors = CardDefaults.cardColors(
            containerColor = branco
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = nome,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = marrom
                )
            }

            if (mostrarPreco) {

                val precoTotal =
                    precoUnitario * quantidade

                Row(
                    modifier = Modifier
                        .height(35.dp)
                        .width(110.dp)
                        .clip(RoundedCornerShape(35))
                        .background(laranjaEscuro),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "R$ $precoUnitario X $quantidade",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = branco
                    )
                }

                Text(
                    text = "R$ $precoTotal",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro,
                    modifier = Modifier.width(70.dp),
                    textAlign = TextAlign.End
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(vermelhoEscuro)
                        .clickable {
                            onDelete()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.less),
                        modifier = Modifier.size(15.dp),
                        contentDescription = "Adicionar",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }
    }
}