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
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

@Composable
fun Outilined(
    modifier: Modifier = Modifier,
    placeHolder: String,
    width: Dp,
    height: Dp,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    mensagemErro: String = ""
) {


    OutlinedTextField(
        modifier = modifier .width(width) .height(height),
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = mensagemErro, color = vermelhoEscuro)
            }
        },
        value = value,
        onValueChange = onValueChange,

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