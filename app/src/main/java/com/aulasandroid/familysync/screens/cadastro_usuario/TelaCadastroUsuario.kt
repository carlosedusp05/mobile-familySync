package com.aulasandroid.familysync.screens.cadastro_usuario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.components.OutilinedIcon
import com.aulasandroid.familysync.components.Profile
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.ui.theme.branco

@Composable
fun TelaCadastroUsuario(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier .fillMaxSize() .background(branco)
    ) {

        RowBack()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.95f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Profile(110.dp)
                Text(
                    text = "Eu",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Outilined(
                    modifier = Modifier,
                    placeHolder = "Nome",
                    width = 383.dp,
                    height = 52.dp
                )

                Outilined(
                    modifier = Modifier,
                    placeHolder = "Email",
                    width = 383.dp,
                    height = 52.dp
                )

                Outilined(
                    modifier = Modifier,
                    placeHolder = "CPF",
                    width = 383.dp,
                    height = 52.dp
                )

                Outilined(
                    modifier = Modifier,
                    placeHolder = "Data de Nascimento",
                    width = 383.dp,
                    height = 52.dp
                )

                OutilinedIcon(
                    modifier = Modifier,
                    placeHolder = "Senha",
                    width = 383.dp,
                    height = 52.dp
                )

                OutilinedIcon(
                    modifier = Modifier,
                    placeHolder = "Confirme a Senha",
                    width = 383.dp,
                    height = 52.dp
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CremeButton(
                    modifier = Modifier,
                    text = "Cancelar",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 22
                )

                OrangeButton(
                    modifier = Modifier,
                    text = "Confirmar",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 22
                )
                }
            }
        }
}