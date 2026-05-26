package com.aulasandroid.familysync.features.eventos.model

data class CriarEventoResponse(
    val Desenvolvedor: String,
    val Version: String,
    val StatusCode: Int,
    val Response: EventoCriado
)


data class EventoCriado(
    val message: String,
    val id_evento: Int
)