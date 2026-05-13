package com.aulasandroid.familysync.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun PersonInformation(
    nome: String,
    estaSelecionado: Boolean,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable{onClick()}
            .background(if (estaSelecionado) laranja else branco)
        ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Profile( 70.dp, onClick)

        Text(
            text = nome,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.clickable{onClick()}
        )
    }
}