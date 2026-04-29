package com.aulasandroid.familysync.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.Logo
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.components.OutilinedIcon
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun TelaLoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(branco),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Logo(modifier = Modifier, 110.dp, 250.dp)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Outilined(
                modifier = Modifier,
                placeHolder = "E-mail",
                width = 383.dp,
                height = 62.dp
            )

            OutilinedIcon(
                modifier = Modifier,
                placeHolder = "Senha",
                width = 383.dp,
                height = 62.dp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OrangeButton(
                modifier = Modifier,
                text = "Entrar",
                width = 200.dp,
                height = 55.dp,
                fontSize = 24
            )

            TextButton(
                onClick = {/* TODO */}
            ) {
                Text(
                    text = "Esqueceu a senha?",
                    color = laranja,
                    textDecoration = TextDecoration.Underline
                )
            }

            CremeButton(
                modifier = Modifier,
                text = "Cadastrar",
                width = 200.dp,
                height = 55.dp,
                fontSize = 24
            )
        }
    }
}