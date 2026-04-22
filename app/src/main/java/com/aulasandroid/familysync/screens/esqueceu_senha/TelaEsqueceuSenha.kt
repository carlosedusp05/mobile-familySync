package com.aulasandroid.familysync.screens.esqueceu_senha

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.components.Logo
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.components.OutilinedIcon
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun TelaEsqueceuSenha(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier .fillMaxSize() .background(branco)
    ) {

        RowBack()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Logo(modifier = Modifier, 110.dp, 250.dp)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Outilined(
                    modifier = Modifier,
                    placeHolder = " Código do Email",
                    width = 383.dp,
                    height = 62.dp
                )

                OutilinedIcon(
                    modifier = Modifier,
                    placeHolder = "Nova Senha",
                    width = 383.dp,
                    height = 62.dp
                )

                OutilinedIcon(
                    modifier = Modifier,
                    placeHolder = "Confirmar Senha",
                    width = 383.dp,
                    height = 62.dp
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OrangeButton(
                    modifier = Modifier,
                    text = "Trocar Senha",
                    width = 200.dp,
                    height = 55.dp,
                    fontSize = 22
                )

                TextButton(
                    onClick = {/* TODO */ }
                ) {
                    Text(
                        text = "reenviar código.",
                        color = laranja
                    )
                }
            }
        }
    }
}