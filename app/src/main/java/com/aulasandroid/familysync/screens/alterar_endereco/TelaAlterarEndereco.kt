package com.aulasandroid.familysync.screens.alterar_endereco

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun TelaAlterarEndereco(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(branco)
    ) {

        RowBack()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.95f),
            verticalArrangement = Arrangement.spacedBy(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .width(230.dp)
                    .height(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Alterar endereço da família",
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = laranja
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(520.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Nome da família",
                        383.dp,
                        52.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Membros(email)",
                        383.dp,
                        52.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Tel(Residencial)",
                        243.dp,
                        52.dp
                    )

                    Outilined(
                        modifier = Modifier,
                        "CEP",
                        133.dp,
                        52.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Cidade",
                        283.dp,
                        52.dp
                    )

                    Outilined(
                        modifier = Modifier,
                        "UF",
                        93.dp,
                        52.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Bairro",
                        383.dp,
                        52.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Logradouro",
                        383.dp,
                        52.dp
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Outilined(
                        modifier = Modifier,
                        "Numero",
                        133.dp,
                        52.dp
                    )

                    Outilined(
                        modifier = Modifier,
                        "Complemento(Opcional)",
                        243.dp,
                        52.dp
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
                        fontSize = 21
                    )
                }
            }
        }
    }
}