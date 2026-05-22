package com.aulasandroid.familysync.features.eventos

import androidx.compose.foundation.background
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Event
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.OutlinedPopUp
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun TelaEventos(navController: NavController) {

    var mostrarPopup by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        RowBack(navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Text(
                text = "MEUS EVENTOS",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = laranja
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Event(
                    navController,
                    "Aniversário da Vó",
                    "Na rua canário Belga 130, é surpresa e tem que levar um prato de comida",
                    "12/02/2026",
                    "20:00",
                    "Paulo",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Consulta Pediatra - Léo",
                    "Levar a caderneta de vacinação e os últimos exames de sangue.",
                    "15/05/2026",
                    "09:30",
                    "Mariana",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Vacina da Gripe",
                    "Posto de saúde central. Não esquecer o cartão do SUS de todos.",
                    "20/05/2026",
                    "08:00",
                    "Carlos",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Revisão do Carro",
                    "Troca de óleo e pastilhas de freio. Orçamento já aprovado.",
                    "18/05/2026",
                    "14:00",
                    "Paulo",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Dedetização da Casa",
                    "Precisamos sair de casa por 4 horas. Combinar de levar o cachorro na pet.",
                    "22/05/2026",
                    "10:00",
                    "Mariana",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Reunião de Pais e Mestres",
                    "Discussão sobre a feira de ciências e formatura do fim do ano.",
                    "25/05/2026",
                    "19:30",
                    "Carlos",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Compras do Mês - Atacadão",
                    "Focar em itens de limpeza e estoque de arroz/feijão.",
                    "05/06/2026",
                    "18:30",
                    "Paulo",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Vencimento Aluguel",
                    "Confirmar se o boleto chegou por e-mail para evitar juros.",
                    "10/06/2026",
                    "09:00",
                    "Mariana",
                    {mostrarPopup = true}
                )

// --- SOCIAL E LAZER ---
                Event(
                    navController,
                    "Churrasco com os Primos",
                    "Cada família leva sua bebida. O Paulo ficou de comprar a carne.",
                    "14/06/2026",
                    "12:00",
                    "Carlos",
                    {mostrarPopup = true}
                )

                Event(
                    navController,
                    "Cinema em Família",
                    "Estreia do novo filme de animação. Comprar ingressos online antes.",
                    "28/05/2026",
                    "16:00",
                    "Paulo",
                    {mostrarPopup = true}
                )
            }
        }

        Footer(navController, "")

        if (mostrarPopup) {
            Dialog(onDismissRequest = { mostrarPopup = false }) {
                Card(
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = branco
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(30.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row(
                            modifier = Modifier
                                .width(200.dp)
                                .height(35.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "DATA:",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = laranjaEscuro
                            )

                            OutlinedMenorDp(
                                "Ex: 01-01-01",
                                130.dp,
                                30.dp,
                                "",
                                {}
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedMenorDp(
                                "Nome",
                                170.dp,
                                35.dp,
                                "",
                                {}
                            )

                            OutlinedMenorDp(
                                "20:00",
                                80.dp,
                                30.dp,
                                "",
                                {}
                            )
                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            OutlinedPopUp(
                                placeHolder = "Descrição",
                                width = 285.dp,
                                height = 140.dp,
                                ""
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CremeButtonPopUp(
                                "Cancelar",
                                {mostrarPopup = false}
                            )

                            OrangeButtonPopUp(
                                "Salvar",
                                {mostrarPopup = false}
                            )

                        }
                    }
                }
            }
        }
    }
}