package com.aulasandroid.familysync.components

import android.content.ClipData
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun Item(
    navController: NavController,
    nome: String,
    precoUnitario: Double,
    quantidade: Int
) {
    var isChecked by remember { mutableStateOf(false) }

    fun onCheckChange(newValue: Boolean) {
        isChecked = newValue
    }

    val precoTotal = precoUnitario * quantidade

    // O Card agora envolve a estrutura para dar a elevação de 4.dp
    Card(
        modifier = Modifier
            .width(350.dp)
            .height(45.dp),
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
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { onCheckChange(it) },
                    modifier = Modifier.size(35.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = laranja,
                        uncheckedColor = marrom,
                        checkmarkColor = branco
                    )
                )
            }
        }
    }
}