package com.aulasandroid.familysync.features.despesas.function

import androidx.compose.ui.graphics.Color
import kotlin.math.absoluteValue

fun gerarCor(index: Int): Color {

    val hue = (index * 137f) % 360f

    return Color.hsv(
        hue = hue,
        saturation = 0.65f,
        value = 0.85f
    )
}