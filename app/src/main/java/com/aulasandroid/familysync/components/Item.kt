package com.aulasandroid.familysync.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aulasandroid.familysync.features.editar_lista.model.TelaEditarListaViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun Item(
    nome: String,
    precoUnitario: String,
    quantidade: Int,
    precoTotal: String,
    isChecked: Boolean,
    listaCompra: Boolean = false,
    onCheckChange: (Boolean) -> Unit
) {
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

            Text(
                text = nome,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = marrom,
                modifier = Modifier.weight(1f)
            )

            if (listaCompra) {

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
                        text = "$precoUnitario X $quantidade",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = branco
                    )
                }

                Text(
                    text = precoTotal,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro,
                    modifier = Modifier.width(70.dp),
                    textAlign = TextAlign.End
                )
            }

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