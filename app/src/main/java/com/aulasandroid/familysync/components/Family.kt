package com.aulasandroid.familysync.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aulasandroid.familysync.R
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.laranja

@Composable
fun Family(
    size: Dp,
    imageUri: Any? = null,
    onClick: (() -> Unit)? = null
) {

    Button(
        onClick = {
            if (onClick != null) onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = branco,
        ),
        shape = RoundedCornerShape(100),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(size),
        border = BorderStroke(2.dp, laranja)
    ) {

        if (imageUri != null) {

            AsyncImage(
                model = imageUri,
                contentDescription = "Foto da família",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

        } else {

            Icon(
                painter = painterResource(R.drawable.family),
                contentDescription = "Ícone família",
                tint = laranja,
                modifier = Modifier.fillMaxSize(0.65f)
            )
        }
    }
}