package com.aulasandroid.familysync.components

import android.icu.number.IntegerWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun OutlinedComboBox(
    width: Dp,
    height: Dp,
    placeholder: String
) {
    OutlinedTextField(
        modifier = Modifier.width(width) .height(height),
        value = "",
        onValueChange = {/* TODO */ },

        shape = RoundedCornerShape(40),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = laranja,
            unfocusedBorderColor = laranja,
        ),

        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        /* TODO */
                    },
                painter = painterResource(R.drawable.forward),
                contentDescription = "seta-familias",
                tint = laranja
            )
        },

        placeholder = {
            Text(placeholder)
        }
    )
}