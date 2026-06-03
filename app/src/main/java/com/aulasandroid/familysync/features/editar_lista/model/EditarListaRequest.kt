package com.aulasandroid.familysync.features.editar_lista.model

data class CriarItemRequest(
    val id_lista: Int,
    val nome_item: String,
    val quantidade: Int,
    val valor_unitario: String,
    val valor_total: String?,
    val comprado: Boolean
)

