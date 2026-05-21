package com.aulasandroid.familysync.features.despesas.model

data class DespesaUiState(
    val titulo: String,
    val icone: String,
    val valorFormatado: String,
    val porcentagem: String,
    val valorNumerico:Float
)