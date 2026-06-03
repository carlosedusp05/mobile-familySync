package com.aulasandroid.familysync.features.editar_lista.model

data class AdicionarItemResponse(
    val Desenvolvedor: String?,
    val Version: String?,
    val StatusCode: Int,
    val Response: CriarItemResponse?
)

data class CriarItemResponse(
    val id_item: Int,
    val id_lista: Int,
    val nome_item: String,
    val quantidade: Int,
    val valor_unitario: String,
    val valor_total: String,
    val comprado: Int
)