package com.aulasandroid.familysync.features.financas.service

import com.aulasandroid.familysync.features.adicionar_financas.model.CriarFinancaRequest
import com.aulasandroid.familysync.features.adicionar_financas.model.CriarFinancaResponse
import com.aulasandroid.familysync.features.editar_financas.model.AtualizarFinancaResponse
import com.aulasandroid.familysync.features.financas.model.BuscarFinancaResponse
import com.aulasandroid.familysync.features.financas.model.FinancasAnuaisResponse
import com.aulasandroid.familysync.features.financas.model.FinancasDiariasResponse
import com.aulasandroid.familysync.features.financas.model.FinancasMensaisResponse
import com.aulasandroid.familysync.features.financas.model.FinancasSemanaisResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface FinancasService {

    @GET("v1/familysync/financas/diarias/{idFamilia}")
    suspend fun buscarFinancasDiarias(
        @Path("idFamilia") idFamilia: Int
    ): Response<FinancasDiariasResponse>

    @GET("v1/familysync/financas/semanais/{idFamilia}")
    suspend fun buscarFinancasSemanais(
        @Path("idFamilia") idFamilia: Int
    ): Response<FinancasSemanaisResponse>

    @GET("v1/familysync/financas/mensais/{idFamilia}")
    suspend fun buscarFinancasMensais(
        @Path("idFamilia") idFamilia: Int
    ): Response<FinancasMensaisResponse>

    @GET("v1/familysync/financas/anuais/{idFamilia}")
    suspend fun buscarFinancasAnuais(
        @Path("idFamilia") idFamilia: Int
    ): Response<FinancasAnuaisResponse>

    @GET("v1/familysync/financas/{idFinanca}")
    suspend fun buscarFinancaPorId(
        @Path("idFinanca") idFinanca: Int
    ): Response<BuscarFinancaResponse>

    //POST
    @Headers("Content-Type: application/json")
    @POST("v1/familysync/financas")
    suspend fun criarFinanca(
        @Body request: CriarFinancaRequest
    ): Response<CriarFinancaResponse>

    //PUT
    @PUT("v1/familysync/financas/{idFinanca}")
    @Headers("Content-Type: application/json")
    suspend fun atualizarFinanca(
        @Path("idFinanca") idFinanca: Int,
        @Body request: CriarFinancaRequest
    ): Response<AtualizarFinancaResponse>

    //DELETE
    @DELETE("v1/familysync/financas/{idFinanca}")
    suspend fun deletarFinanca(
        @Path("idFinanca") idFinanca: Int
    ): Response<Unit>
}