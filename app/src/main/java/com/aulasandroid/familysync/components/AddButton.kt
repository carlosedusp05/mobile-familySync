package com.aulasandroid.familysync.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun AddButton() {
    Button(
        onClick = {/* TODO */},
        colors = ButtonDefaults.buttonColors(
            containerColor = laranja
        ),
        shape = RoundedCornerShape(100),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier .size(52.dp)
    ){
        Icon(
            painter = painterResource(R.drawable.plus),
            contentDescription = "botao-criar",
            tint = branco,
            modifier = Modifier .size(25.dp)
        )
    }
}