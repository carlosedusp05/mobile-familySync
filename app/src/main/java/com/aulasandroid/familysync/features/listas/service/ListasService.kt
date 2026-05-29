package com.aulasandroid.familysync.features.listas.service

import com.aulasandroid.familysync.features.criar_lista.model.CriarListaRequest
import com.aulasandroid.familysync.features.criar_lista.model.CriarListaResponse
import com.aulasandroid.familysync.features.editar_lista.model.CriarItemRequest
import com.aulasandroid.familysync.features.editar_lista.model.CriarItemResponse
import com.aulasandroid.familysync.features.editar_lista.model.DeleteItemResponse
import com.aulasandroid.familysync.features.editar_lista.model.FamiliaCompletaResponse
import com.aulasandroid.familysync.features.listas.model.FavoritaRequest
import com.aulasandroid.familysync.features.listas.model.FavoritaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ListasService {
    @GET("v1/familysync/lista/completa/familia/{id}")
    suspend fun buscarFamiliaCompleta(
        @Path("id") id: Int
    ): Response<FamiliaCompletaResponse>

    @Headers("Content-Type: application/json")
    @POST("v1/familysync/item")
    suspend fun criarItem(
        @Body request: CriarItemRequest
    ): Response<CriarItemResponse>

    @DELETE("v1/familysync/item/{id}")
    suspend fun deletarItem(
        @Path("id") id: Int
    ): Response<DeleteItemResponse>

    @Headers(
        "Content-Type: application/json"
    )
    @PUT("v1/familysync/lista/favorita/{id}")
    suspend fun atualizarFavorita(
        @Path("id") id: Int,
        @Body request: FavoritaRequest
    ): Response<FavoritaResponse>

    @DELETE("v1/familysync/lista/{id}")
    suspend fun deletarLista(
        @Path("id") id: Int
    ): Response<FavoritaResponse>

    @Headers(
        "Content-Type: application/json"
    )
    @POST("v1/familysync/lista")
    suspend fun criarLista(
        @Body request: CriarListaRequest
    ): Response<CriarListaResponse>
}