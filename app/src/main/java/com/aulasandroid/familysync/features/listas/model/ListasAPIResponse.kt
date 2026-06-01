package com.aulasandroid.familysync.features.listas.model

import com.aulasandroid.familysync.features.editar_lista.model.ItemResponse

data class ListaComUsuario(
    val idLista: Int,
    val nomeLista: String,
    val idUsuario: Int,
    val nomeUsuario: String,
    val favorita: Int,
    val itens: List<ItemResponse>
)

data class FavoritaResponse(
    val Desenvolvedor: String?,
    val Version: String?,
    val StatusCode: Int,
    val Response: String?
)