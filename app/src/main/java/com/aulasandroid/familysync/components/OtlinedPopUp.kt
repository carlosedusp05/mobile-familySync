package com.aulasandroid.familysync.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun OutlinedPopUp(
    placeHolder: String,
    width: Dp,
    height: Dp,
    value: String
) {

    var textoState by remember {
        mutableStateOf(value)
    }

    OutlinedTextField(
        modifier = Modifier.width(width) .height(height),
        value = textoState,
        onValueChange = {
            textoState = it
        },

        shape = RoundedCornerShape(15.dp),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = laranja,
            unfocusedBorderColor = laranja,
        ),

        placeholder = {
            Text(
                text = placeHolder,
                fontSize = 12.sp
            )
        }
    )
}