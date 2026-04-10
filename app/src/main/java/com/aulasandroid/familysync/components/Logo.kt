package com.aulasandroid.familysync.components

import android.icu.number.IntegerWidth
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.aulasandroid.familysync.R

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    heigth: Dp,
    width: Dp
) {
    IconButton(
        modifier = modifier .height(heigth) .width(width),
        onClick = {/* TODO */}
    )  {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = modifier .fillMaxSize()
        )
    }
}