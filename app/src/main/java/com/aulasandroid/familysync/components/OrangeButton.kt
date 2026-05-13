package com.aulasandroid.familysync.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun OrangeButton(
    modifier: Modifier = Modifier,
    text: String,
    width: Dp,
    height: Dp,
    fontSize: Int,
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
                    "login"                 -> navController.navigate("home")
                    "esqueceu_senha"        -> navController.navigate("esqueceu_senha")
                    "cadastro_usuario"      -> navController.navigate("cadastro_usuario")
                    "perfil"                -> navController.navigate("perfil")
                    "cadastro_familia"      -> navController.navigate("cadastro_familia")
                    "home_sem_familia"      -> navController.navigate("cadastro_familia")
                    "adicionar_despesas"    -> navController.navigate("despesas")
                    "editar_despesas"       -> navController.navigate("despesas")
                    "alterar_endereco"      -> navController.navigate("gerenciador_familiar")
                    "gerenciador_familiar"  -> navController.navigate("gerenciador_familiar")
                    "informacoes_familiar"  -> navController.navigate("informacoes_familiar")
                    "lista"                 -> navController.navigate("lista")
                    "editar-lista"          -> navController.navigate("lista")
                    "criar-lista"           -> navController.navigate("listas")
                    else                -> navController.navigate("home")
                }
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = laranja
        ),
        shape = RoundedCornerShape(40),
        modifier = modifier .width(width) .height(height)
    ){
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize.sp
        )
    }
}