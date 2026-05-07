package com.aulasandroid.familysync.features.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.components.AddButton
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.LeftArrow
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.Profile
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun TelaPerfil(navController: NavController) {
    var mostrarPopup by remember { mutableStateOf( false) }

    Column(
        modifier = Modifier.fillMaxSize().background(branco)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .padding(horizontal = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LeftArrow(navController)

            IconButton(
                onClick = { mostrarPopup = true },
                modifier = Modifier.size(43.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.out),
                    contentDescription = "sair-conta",
                    tint = laranjaEscuro,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

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
                Profile( 110.dp)
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
                    .height(460.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Outilined(
//                    modifier = Modifier,
//                    placeHolder = "Nome",
//                    width = 383.dp,
//                    height = 52.dp
//                )
//
//                Outilined(
//                    modifier = Modifier,
//                    placeHolder = "Email",
//                    width = 383.dp,
//                    height = 52.dp
//                )
//
//                Outilined(
//                    modifier = Modifier,
//                    placeHolder = "CPF",
//                    width = 383.dp,
//                    height = 52.dp
//                )
//
//                Outilined(
//                    modifier = Modifier,
//                    placeHolder = "Data de Nascimento",
//                    width = 383.dp,
//                    height = 52.dp
//                )
//
//                OutilinedIcon(
//                    modifier = Modifier,
//                    placeHolder = "Senha",
//                    width = 383.dp,
//                    height = 52.dp
//                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedTextField(
                        modifier = Modifier.width(313.dp) .height(52.dp),
                        value = "",
                        onValueChange = {/* TODO */ },

                        shape = RoundedCornerShape(40),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = laranja,
                            unfocusedBorderColor = laranja,
                        ),

                        trailingIcon = {
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .clickable {
                                        /* TODO */
                                    },
                                painter = painterResource(R.drawable.forward),
                                contentDescription = "seta-familias",
                                tint = laranja
                            )
                        },

                        placeholder = {
                            Text("Família")
                        }
                    )

                    AddButton(52.dp, navController, "perfil")
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
                        fontSize = 22,
                        navController,
                        "perfil"
                    )

                    OrangeButton(
                        modifier = Modifier,
                        text = "Confirmar",
                        width = 150.dp,
                        height = 55.dp,
                        fontSize = 21,
                        navController,
                        "perfil"
                    )
                }
            }
        }

        if (mostrarPopup) {
            Dialog(onDismissRequest = { mostrarPopup = false }) {
                Card(
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .background(branco)
                            .padding(30.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Deseja memso sair da sua conta?",
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = marrom
                        )

                        Row(
                            modifier = Modifier
                                .width(280.dp)
                                .height(42.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CremeButtonPopUp(
                                "Cancelar",
                                {mostrarPopup = false}
                            )

                            OrangeButtonPopUp(
                                "Sair",
                                {navController.navigate("login")}
                            )

                        }
                    }
                }
            }
        }
    }
}