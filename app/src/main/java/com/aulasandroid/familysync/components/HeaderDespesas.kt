package com.aulasandroid.familysync.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.marrom

@Composable
fun HeaderDespesas(
    nomeTela: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(
                bottomEnd = 10.dp,
                bottomStart = 10.dp
            ))
            .background(marrom)
    ) {
        Row(
           modifier = Modifier
               .fillMaxWidth()
               .height(50.dp)
               .padding(start = 20.dp)
        ) {
            Button(
                onClick = {/* TODO */},
                colors = ButtonDefaults.buttonColors(
                    containerColor = laranja
                ),
                shape = RoundedCornerShape(100),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier .size(50.dp)
            ){
                Icon(
                    painter = painterResource(R.drawable.arrow),
                    contentDescription = "seta-de-voltar",
                    tint = marrom,
                    modifier = Modifier .size(25.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = nomeTela,
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}