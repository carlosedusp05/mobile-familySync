package com.aulasandroid.familysync.features.eventos.model

data class EventoRequest(
    val id_eventos: Int,
    val id_familia: Int,
    val id_usuario: Int,
    val titulo: String,
    val descricao: String,
    val data: String,
    val hora: String
)