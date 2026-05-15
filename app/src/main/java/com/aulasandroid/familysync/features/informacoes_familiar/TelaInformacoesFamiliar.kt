package com.aulasandroid.familysync.features.informacoes_familiar

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.Information
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.OutlinedPopUp
import com.aulasandroid.familysync.components.PersonInformation
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun TelaInformacoesFamiliar(navController: NavController) {
    var mostrarPopup by remember { mutableStateOf(false) }
    var mostrarPopupEditar by remember { mutableStateOf(false) }

    var estaSelecionado by remember { mutableStateOf("pessoa 0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header(navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85F),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "INFORMAÇÕES FAMILIAR",
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = laranja
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
                    .height(120.dp)
                    .horizontalScroll(rememberScrollState())
                    .imePadding(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                PersonInformation(
                    "pessoa 0",
                    (estaSelecionado == "pessoa 0"),
                    {estaSelecionado = "pessoa 0"}
                )

                PersonInformation(
                    "pessoa 1",
                    (estaSelecionado == "pessoa 1"),
                    {estaSelecionado = "pessoa 1"}
                )

                PersonInformation(
                    "pessoa 2",
                    (estaSelecionado == "pessoa 2"),
                    {estaSelecionado = "pessoa 2"}
                )

                PersonInformation(
                    "pessoa 3",
                    (estaSelecionado == "pessoa 3"),
                    {estaSelecionado = "pessoa 3"}
                )

                PersonInformation(
                    "pessoa 4",
                    (estaSelecionado == "pessoa 4"),
                    {estaSelecionado = "pessoa 4"}
                )

                PersonInformation(
                    "pessoa 5",
                    (estaSelecionado == "pessoa 5"),
                    {estaSelecionado = "pessoa 5"}
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv",
                    navController,
                    {mostrarPopupEditar = true}
                )

                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv",
                    navController,
                    {mostrarPopupEditar = true}
                )

                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv",
                    navController,
                    {mostrarPopupEditar = true}
                )

                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv",
                    navController,
                    {mostrarPopupEditar = true}
                )

                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv",
                    navController,
                    {mostrarPopupEditar = true}
                )
            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                OrangeButton(
                    Modifier,
                    "Criar uma informação",
                    280.dp,
                    70.dp,
                    21,
                    navController,
                    "informacoes_familiar",
                    onClick = { mostrarPopup = true }
                )
            }
        }

        Footer(navController, "informacao")

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
                    ) {
                        OutlinedMenorDp(
                            "Título",
                            150.dp,
                            42.dp,
                            "",
                            {}
                        )

                        OutlinedPopUp(
                            "Descrição",
                            280.dp,
                            150.dp,
                            ""
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
                                "Criar",
                                {mostrarPopup = false}
                            )

                        }
                    }
                }
            }
        }

        if (mostrarPopupEditar) {
            Dialog(onDismissRequest = { mostrarPopupEditar = false }) {
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
                    ) {
                        OutlinedMenorDp(
                            "Título",
                            150.dp,
                            42.dp,
                            "Alergia",
                            {}
                        )

                        OutlinedPopUp(
                            "Descrição",
                            280.dp,
                            150.dp,
                            "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv"
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
                                {mostrarPopupEditar = false}
                            )

                            OrangeButtonPopUp(
                                "Salvar",
                                {mostrarPopupEditar = false}
                            )

                        }
                    }
                }
            }
        }
    }
}