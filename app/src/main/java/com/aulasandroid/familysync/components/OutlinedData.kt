package com.aulasandroid.familysync.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

@Composable
fun OutilinedData(
    modifier: Modifier = Modifier,
    placeHolder: String,
    width: Dp,
    height: Dp,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isError: Boolean = false,
    mensagemErro: String = "",
    visualTransformation: VisualTransformation =
        VisualTransformation.None,
    keyboardType: KeyboardType,
    keyboardImeAction: ImeAction = ImeAction.Done
) {
    val focusManager = LocalFocusManager.current

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

        visualTransformation = visualTransformation,

        shape = RoundedCornerShape(40),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = laranja,
            unfocusedBorderColor = laranja,
        ),

        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = keyboardImeAction
        ),

        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            },
            onNext = {
                focusManager.clearFocus()

            }
        ),


        singleLine = true,

        placeholder = {
            Text(placeHolder)
        }
    )
}