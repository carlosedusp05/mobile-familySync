package com.aulasandroid.familysync.components


import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.laranja

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedMenorDp(
    placeHolder: String,
    width: Dp,
    height: Dp,
    value: String
) {
    var textoState by remember { mutableStateOf(value) }

    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = textoState,
        onValueChange = { textoState = it },
        modifier = Modifier
            .width(width)
            .height(height),
        interactionSource = interactionSource,
        enabled = true,
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 12.sp,
            color = Color.Black,
            textAlign = TextAlign.Start
        ),
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = textoState,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                placeholder = {
                    Text(
                        text = placeHolder,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                },
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                container = {
                    OutlinedTextFieldDefaults.ContainerBox(
                        enabled = true,
                        isError = false,
                        interactionSource = interactionSource,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = laranja,
                            unfocusedBorderColor = laranja,
                        ),
                        shape = RoundedCornerShape(15.dp),
                        focusedBorderThickness = 1.dp,
                        unfocusedBorderThickness = 1.dp
                    )
                }
            )
        }
    )
}