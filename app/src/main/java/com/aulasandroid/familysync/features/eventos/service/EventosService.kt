package com.aulasandroid.familysync.features.eventos.service

import com.aulasandroid.familysync.features.eventos.model.EventosAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface EventosService {
    @GET("v1/familysync/eventos/familia/3")
    suspend fun buscarEventos(): Response<EventosAPIResponse>
}