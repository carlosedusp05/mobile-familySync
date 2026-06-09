package com.aulasandroid.familysync.features.informacoes_familiar.service

import com.aulasandroid.familysync.features.informacoes_familiar.model.BuscarInformacoesFamiliaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InformacoesService {
    @GET("v1/familysync/usuario-informacao/familia/{idFamilia}")
    suspend fun buscarInformacoesFamilia(
        @Path("idFamilia") idFamilia: Int
    ): Response<BuscarInformacoesFamiliaResponse>
}