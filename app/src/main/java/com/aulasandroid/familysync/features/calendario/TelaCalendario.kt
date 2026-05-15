package com.aulasandroid.familysync.features.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.CremeButtonPopUp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.OrangeButtonPopUp
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.OutlinedPopUp
import com.aulasandroid.familysync.features.calendario.model.TelaCalendarioViewModel
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranjaEscuro
import com.aulasandroid.familysync.ui.theme.marrom
import com.aulasandroid.familysync.ui.theme.vermelho

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCalendario(
    navController: NavController,
    viewModel: TelaCalendarioViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    ) {
    var mostrarPopup by remember { mutableStateOf(false) }

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
                .fillMaxHeight(0.9f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "CALENDÁRIO",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = laranjaEscuro
                )
            }

            Card(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .border(4.dp, marrom, RoundedCornerShape(3))
                    .fillMaxWidth()
                    .height(390.dp),
                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                // Dentro dessa Column
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(creme)

                ) {
                    DatePicker(
                        state = viewModel.datePickerState,
                        showModeToggle = false,
                        title = null,
                        headline = null,
                        colors = DatePickerDefaults.colors(
                            navigationContentColor = marrom,
                            yearContentColor = marrom,
                            containerColor = creme,
                            titleContentColor = laranjaEscuro,
                            headlineContentColor = laranjaEscuro,
                            weekdayContentColor = marrom,
                            subheadContentColor = marrom,
                            selectedDayContainerColor = laranjaEscuro,
                            selectedDayContentColor = marrom,
                            todayContentColor = laranjaEscuro,
                            todayDateBorderColor = laranjaEscuro
                        )
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CremeButton(
                    modifier = Modifier,
                    text = "ver eventos",
                    width = 170.dp,
                    height = 55.dp,
                    fontSize = 20,
                    navController,
                    "calendario"
                )

                OrangeButton(
                    modifier = Modifier,
                    text = "criar eventos",
                    width = 170.dp,
                    height = 55.dp,
                    fontSize = 18,
                    navController,
                    "",
                    {mostrarPopup = true}
                )
            }
        }

        Footer(navController, "calendario")

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
                                "Ex: 01/01/01",
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
                                "Ex: 01/01/01",
                                150.dp,
                                35.dp,
                                "",
                                {}
                            )

                            OutlinedMenorDp(
                                "20:00",
                                80.dp,
                                35.dp,
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
                                "Criar",
                                {mostrarPopup = false}
                            )

                        }
                    }
                }
            }
        }
    }
}