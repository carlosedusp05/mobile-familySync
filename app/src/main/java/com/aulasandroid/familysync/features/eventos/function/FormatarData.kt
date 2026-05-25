package com.aulasandroid.familysync.features.eventos.function

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun formatarData(dataApi: String): String {

    val data =
        LocalDate.parse(dataApi.substring(0, 10))

    val formato =
        DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return data.format(formato)
}