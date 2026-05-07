package com.aulasandroid.familysync.components

import androidx.annotation.Size
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun AddButton(
    size: Dp,
    navController: NavController,
    abaAtiva: String,
    onClick: (() -> Unit)? = null
) {
    Button(
        onClick = {
            if (onClick != null) {
                onClick()
            } else {
                when(abaAtiva) {
                    "despesas"              -> navController.navigate("adicionar_despesas")
                    "gerenciador_familiar"  -> navController.navigate("gerenciador_familiar")
                    "perfil"                -> navController.navigate("cadastro_familia")
                    else                    -> navController.navigate("home")
                }
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = laranja
        ),
        shape = RoundedCornerShape(100),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier .size(size)
    ){
        Icon(
            painter = painterResource(R.drawable.plus),
            contentDescription = "botao-criar",
            tint = branco,
            modifier = Modifier .fillMaxSize(0.5f)
        )
    }
}