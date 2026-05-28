package com.aulasandroid.familysync.features.eventos.model

data class AtualizarEventoRequest(

    val titulo: String,
    val descricao: String,
    val data: String,
    val hora: String
)