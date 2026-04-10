package com.aulasandroid.familysync.components

import android.widget.Button
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.familysync.ui.theme.creme
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun CremeButton(
    modifier: Modifier = Modifier,
    text: String,
    width: Dp,
    height: Dp,
    fontSize: Int
) {
    Button(
        onClick = {/* TODO */},
        colors = ButtonDefaults.buttonColors(
            containerColor = creme
        ),
        shape = RoundedCornerShape(40),
        modifier = modifier .width(width) .height(height)
    ){
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = laranja,
            fontSize = fontSize.sp
        )
    }
}