package com.aulasandroid.familysync.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun Outilined(
    modifier: Modifier = Modifier,
    placeHolder: String,
    width: Dp,
    height: Dp
) {


    OutlinedTextField(
        modifier = modifier .width(width) .height(height),
        value = "",
        onValueChange = {/* TODO */},

        shape = RoundedCornerShape(40),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = laranja,
            unfocusedBorderColor = laranja,
        ),

        placeholder = {
            Text(placeHolder)
        }
    )
}