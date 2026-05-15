package com.aulasandroid.familysync.features.cadastro_familia.ui

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CEPVisualTransformation: VisualTransformation  {
    override fun filter(text: AnnotatedString): TransformedText {

        val digits = text.text
            .filter { it.isDigit() }
            .take(8)

        val formatted = buildString {

            digits.forEachIndexed { index, c ->

                append(c)

                if (index == 4) {
                    append("-")
                }
            }
        }

        val offsetMapping = object : OffsetMapping {

            override fun originalToTransformed(offset: Int): Int {

                return when {

                    offset <= 4 -> offset

                    offset <= 8 -> offset + 1

                    else -> formatted.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {

                return when {

                    offset <= 5 -> offset

                    offset <= 9 -> offset - 1

                    else -> digits.length
                }
            }
        }

        return TransformedText(
            AnnotatedString(formatted),
            offsetMapping
        )
    }
}
