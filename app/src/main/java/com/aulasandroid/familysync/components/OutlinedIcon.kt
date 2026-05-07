package com.aulasandroid.familysync.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.laranja
import com.aulasandroid.familysync.ui.theme.vermelho
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

@Composable
fun OutilinedIcon(
    modifier: Modifier = Modifier,
    placeHolder: String,
    width: Dp,
    height: Dp,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    mensagemErro: String = ""
) {

    var visivel by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = modifier .width(width) .height(height),
        isError = isError,
        value = value,
        onValueChange = onValueChange,

        shape = RoundedCornerShape(40),

        visualTransformation = if (visivel) VisualTransformation.None else PasswordVisualTransformation(),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = laranja,
            unfocusedBorderColor = laranja,
        ),

        supportingText = {
            if (isError) {
                Text(
                    text = mensagemErro,
                    color = vermelhoEscuro
                )
            }
        },

        trailingIcon = {
            if (visivel) {
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{
                            visivel = false
                        },
                    painter = painterResource(R.drawable.eye),
                    contentDescription = "visivel",
                    tint = laranja
                )
            }else {

                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{
                            visivel = true
                        },
                    painter = painterResource(R.drawable.closed_eye),
                    contentDescription = "invisivel",
                    tint = laranja
                )
            }
        },

        placeholder = {
            Text(placeHolder)
        }
    )
}