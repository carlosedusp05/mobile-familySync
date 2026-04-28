package com.aulasandroid.familysync.screens.informacoes_familiar

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.components.Footer
import com.aulasandroid.familysync.components.Header
import com.aulasandroid.familysync.components.Information
import com.aulasandroid.familysync.components.Notification
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.PersonInformation
import com.aulasandroid.familysync.components.Profile
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.laranjaEscuro

@Composable
fun TelaInformacoesFamiliar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(branco),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85F),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Informações familiar",
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
                PersonInformation("pessoa 0")
                PersonInformation("pessoa 1")
                PersonInformation("pessoa 2")
                PersonInformation("pessoa 3")
                PersonInformation("pessoa 4")
                PersonInformation("pessoa 5")
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
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv"
                )

                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv"
                )

                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv"
                )

                Information(
                    tema = "Alergia",
                    conteudo = "jchbhwubehwvcwruievcruiewvcrievgcghdvskdg vgdfhksvcfghkdfvcsghkdvcfghksvcsdikv"
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
                    21
                )
            }
        }

        Footer()
    }
}