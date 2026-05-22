package com.aulasandroid.familysync.features.lista.model

data class ProdutoItem(
    val id: Int,
    val nome: String,
    val precoUnitario: Double,
    val quantidade: Int,
    var isChecked: Boolean = false
)