package com.aulasandroid.familysync.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(branco),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(230.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Logo(Modifier,90.dp, 210.dp)
            }

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(170.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Profile(65.dp)

                Button(
                    onClick = {/* TODO */},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = laranja
                    ),
                    shape = RoundedCornerShape(10),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier .width(35.dp) .height(35.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.email),
                        contentDescription = "seta-de-voltar",
                        tint = branco,
                        modifier = Modifier .size(20.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
                .background(laranja)
        ){}
    }
}