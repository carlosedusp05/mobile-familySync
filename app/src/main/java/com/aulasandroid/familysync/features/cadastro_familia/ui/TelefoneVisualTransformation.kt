package com.aulasandroid.familysync.features.cadastro_familia.ui

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class TelefoneVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {

        val input = text.text.filter { it.isDigit() }.take(10)

        val formatted = buildString {

            input.forEachIndexed { index, char ->

                when (index) {
                    0 -> append("(")
                    2 -> append(") ")
                    6 -> append("-")
                }

                append(char)
            }
        }

        val offsetTranslator = object : OffsetMapping {

            override fun originalToTransformed(offset: Int): Int {

                return when {
                    offset <= 0 -> offset
                    offset <= 2 -> offset + 1
                    offset <= 6 -> offset + 3
                    offset <= 10 -> offset + 4
                    else -> formatted.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {

                return when {
                    offset <= 1 -> offset
                    offset <= 4 -> offset - 1
                    offset <= 9 -> offset - 3
                    offset <= 15 -> offset - 4
                    else -> input.length
                }
            }
        }

        return TransformedText(
            text = AnnotatedString(formatted),
            offsetMapping = offsetTranslator
        )
    }
}