package com.aulasandroid.familysync.components

import android.icu.number.IntegerWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.CanvasHolder
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun OutlinedPopUp(
    placeHolder: String,
    width: Dp,
    height: Dp
) {
    OutlinedTextField(
        modifier = Modifier .width(width) .height(height),
        value = "",
        onValueChange = {/* TODO */},

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