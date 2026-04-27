package com.aulasandroid.familysync.screens.notificacao

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Notification
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun TelaNotificacao(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        RowBack()

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
                Notification()
                Notification()
                Notification()
                Notification()
                Notification()
                Notification()
                Notification()
                Notification()
            }
        }

        Footer()
    }
}