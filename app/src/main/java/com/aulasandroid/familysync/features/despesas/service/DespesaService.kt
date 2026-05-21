package com.aulasandroid.familysync.features.despesas.service

import com.aulasandroid.familysync.features.despesas.model.DespesaAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface DespesaService {
    @GET("v1/familysync/financas")
    suspend fun buscarDespesa(): Response<DespesaAPIResponse>
}