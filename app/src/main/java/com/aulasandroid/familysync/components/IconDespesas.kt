package com.aulasandroid.familysync.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun IconDespesas(
    idIcon: Int
) {
    Button(
        onClick = {/* TODO */},
        colors = ButtonDefaults.buttonColors(
            containerColor = branco
        ),
        shape = RoundedCornerShape(100),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier .size(65.dp),
        border = BorderStroke(3.dp, laranjaEscuro)
    ){
        Icon(
            painter = painterResource(idIcon),
            contentDescription = "seta-de-voltar",
            tint = laranjaEscuro,
            modifier = Modifier .size(40.dp)
        )
    }
}
