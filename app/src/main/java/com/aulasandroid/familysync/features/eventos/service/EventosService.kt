package com.aulasandroid.familysync.features.eventos.service

import com.aulasandroid.familysync.features.eventos.model.CriarEventoResponse
import com.aulasandroid.familysync.features.eventos.model.DeletarEventoResponse
import com.aulasandroid.familysync.features.eventos.model.EventoRequest
import com.aulasandroid.familysync.features.eventos.model.EventoResponse
import com.aulasandroid.familysync.features.eventos.model.EventosAPIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface EventosService {
    @GET("v1/familysync/eventos/familia/3")
    suspend fun buscarEventos(): Response<EventosAPIResponse>

    @Headers(
        "Content-Type: application/json"
    )
    @POST("v1/familysync/evento")
    suspend fun criarEvento(
        @Body request: EventoRequest
    ): Response<CriarEventoResponse>

    @DELETE("v1/familysync/evento/{id}")
    suspend fun deletarEvento(
        @Path("id") id: Int
    ): Response<DeletarEventoResponse>
}