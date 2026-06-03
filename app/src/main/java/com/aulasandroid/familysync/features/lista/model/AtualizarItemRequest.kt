package com.aulasandroid.familysync.features.lista.model

data class AtualizarItemRequest(
    val id_lista: Int,
    val nome_item: String,
    val quantidade: Int,
    val valor_unitario: String,
    val valor_total: String?,
    val comprado: Boolean
)

data class AtualizarListaRequest(
    val id_familia: Int,
    val id_usuario: Int,
    val nome: String
)