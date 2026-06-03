package com.aulasandroid.familysync.features.listas.model

data class FavoritaRequest(
    val favorita: Boolean
)

data class CriarListaRequest(

    val id_familia: Int,
    val id_usuario: Int,
    val nome: String
)

