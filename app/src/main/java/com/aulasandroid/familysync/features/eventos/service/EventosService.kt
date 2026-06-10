package com.aulasandroid.familysync.features.eventos.service

import com.aulasandroid.familysync.features.eventos.model.AtualizarEventoRequest
import com.aulasandroid.familysync.features.eventos.model.AtualizarEventoResponse
import com.aulasandroid.familysync.features.eventos.model.CriarEventoResponse
import com.aulasandroid.familysync.features.eventos.model.DeletarEventoRequest
import com.aulasandroid.familysync.features.eventos.model.EventoRequest
import com.aulasandroid.familysync.features.eventos.model.EventosAPIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EventosService {
    @GET("v1/familysync/eventos/familia/39")
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
    ): Response<DeletarEventoRequest>

    @Headers("Content-Type: application/json")
    @PUT("v1/familysync/evento/{id}")
    suspend fun atualizarEvento(

        @Path("id") id: Int,
        @Body request: AtualizarEventoRequest

    ): Response<AtualizarEventoResponse>
}