package com.aulasandroid.familysync.features.listas.model

data class ListasAPIResponse(
    val Response: ListaResponse
)

data class ListaResponse(
    val usuarios: List<UsuarioLista>,
    val listas: List<ListaResponseItem>,
    val items: List<ItemResponse>
)

data class UsuarioLista(
    val id_usuario: Int,
    val nome_criado: String
)

data class ListaResponseItem(
    val id_lista: Int,
    val id_familia: Int,
    val id_usuario: Int,
    val nome: String
)

data class ItemResponse(
    val id_item: Int,
    val id_lista: Int,
    val nome_item: String,
    val quantidade: Int,
    val valor_unitario: String,
    val valor_total: String?,
    val comprado: Int
)