package com.aulasandroid.familysync.mask

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CpfVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {

        val digits = text.text
            .filter { it.isDigit() }
            .take(11)

        val formatted = buildString {

            digits.forEachIndexed { index, c ->

                append(c)

                when (index) {
                    2, 5 -> append(".")
                    8 -> append("-")
                }
            }
        }

        val offsetMapping = object : OffsetMapping {

            override fun originalToTransformed(offset: Int): Int {

                return when {

                    offset <= 2 -> offset

                    offset <= 5 -> offset + 1

                    offset <= 8 -> offset + 2

                    offset <= 11 -> offset + 3

                    else -> formatted.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {

                return when {

                    offset <= 2 -> offset

                    offset <= 6 -> offset - 1

                    offset <= 10 -> offset - 2

                    offset <= 14 -> offset - 3

                    else -> digits.length
                }
            }
        }

        return TransformedText(
            androidx.compose.ui.text.AnnotatedString(formatted),
            offsetMapping
        )
    }
}