package com.aulasandroid.familysync.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aulasandroid.familysync.features.despesas.function.gerarCor

@Composable
fun Graphic(
    fatias: List<Float>,
    cores: List<Color>
) {
    val total = fatias.sum().takeIf { it > 0 } ?: 1f

    Canvas(modifier = Modifier.size(200.dp)) {

        var anguloInicial = -90f

        fatias.forEachIndexed { index, valor ->

            val cor = cores.getOrElse(index) {
                gerarCor(index) // fallback seguro
            }

            val anguloVarredura = (valor / total) * 360f

            drawArc(
                color = cor,
                startAngle = anguloInicial,
                sweepAngle = anguloVarredura,
                useCenter = true
            )

            anguloInicial += anguloVarredura
        }
    }
}