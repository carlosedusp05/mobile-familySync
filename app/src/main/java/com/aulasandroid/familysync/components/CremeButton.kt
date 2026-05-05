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
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun CremeButton(
    modifier: Modifier = Modifier,
    text: String,
    width: Dp,
    height: Dp,
    fontSize: Int,
    navController: NavController,
    abaAtiva: String
) {
    Button(
        onClick = {
            when (abaAtiva) {
                "login" -> navController.navigate("cadastro_usuario")
                "alterar_endereco" -> navController.navigate("gerenciador_familiar")
                "cadastro_usuario" -> navController.navigate("login")
                "cadastro_familia" -> navController.popBackStack()
                else -> navController.navigate("perfil")
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = creme
        ),
        shape = RoundedCornerShape(40),
        modifier = modifier .width(width) .height(height)
    ){
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = laranja,
            fontSize = fontSize.sp
        )
    }
}