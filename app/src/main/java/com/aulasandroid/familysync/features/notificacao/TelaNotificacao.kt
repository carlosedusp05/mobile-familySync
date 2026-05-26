package com.aulasandroid.familysync.features.notificacao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Notification
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.features.notificacao.model.TelaNotificacaoViewModel
import com.aulasandroid.familysync.mask.function.formatarData
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun TelaNotificacao(
    navController: NavController,
    viewModel: TelaNotificacaoViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LaunchedEffect(Unit) {
            viewModel.buscarNotificacoes()
        }

        RowBack(navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Text(
                text = "NOTIFICAÇÕES",
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
                viewModel.listaNotificacoes.forEach { notificacao ->
                    Notification(
                        tema = notificacao.titulo,
                        descricao = notificacao.descricao,
                        data = formatarData( notificacao.data)
                    )
                }
            }
        }

        Footer(navController, "")
    }
}