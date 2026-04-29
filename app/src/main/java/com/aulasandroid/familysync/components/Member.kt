package com.aulasandroid.familysync.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun Member(
    nome: String,
    parentesco: String
) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Profile(70.dp)

        // Coluna central flexível
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = nome,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = laranja
            )

            Text(
                text = "Grau de parentesco: $parentesco",
                fontSize = 10.sp,
                color = marrom
            )
        }

        // Seletor de Permissões
        Column(
            modifier = Modifier.width(150.dp),
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier.clickable { isExpanded = !isExpanded },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Pode editar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = marrom
                )
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    tint = marrom,
                    contentDescription = null
                )
            }

            if (isExpanded) {
                Column(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .border(1.dp, laranja, RoundedCornerShape(4.dp))
                        .background(Color.White)
                        .padding(8.dp)
                ) {
                    // Use o nome exato do seu componente de CheckBox
                    CheckBox("Calendário")
                    CheckBox("Lista")
                    CheckBox("Despesas")
                    CheckBox("Informações")
                }
            }
        }
    }
}