package com.aulasandroid.familysync.features.listas.service


import com.aulasandroid.familysync.features.editar_lista.model.AdicionarItemResponse
import com.aulasandroid.familysync.features.editar_lista.model.CriarItemRequest
import com.aulasandroid.familysync.features.lista.model.AtualizarItemRequest
import com.aulasandroid.familysync.features.lista.model.AtualizarItemResponse
import com.aulasandroid.familysync.features.lista.model.AtualizarListaRequest
import com.aulasandroid.familysync.features.listas.model.APIListasResponse
import com.aulasandroid.familysync.features.listas.model.CriarListaRequest
import com.aulasandroid.familysync.features.listas.model.FamiliaCompletaListasResponse
import com.aulasandroid.familysync.features.listas.model.FavoritaRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ListasService {

    // GETS
    @GET("v1/familysync/lista/completa/familia/{id}")
    suspend fun buscarFamiliaCompleta(
        @Path("id") id: Int
    ): Response<FamiliaCompletaListasResponse>


    // POSTS
    @Headers("Content-Type: application/json")
    @POST("v1/familysync/lista")
    suspend fun criarLista(
        @Body request: CriarListaRequest
    ): Response<APIListasResponse>

    @Headers("Content-Type: application/json")
    @POST("v1/familysync/item")
    suspend fun criarItem(
        @Body request: CriarItemRequest
    ): Response<AdicionarItemResponse>


    // DELETES
    @DELETE("v1/familysync/lista/{id}")
    suspend fun deletarLista(
        @Path("id") id: Int
    ): Response<APIListasResponse>

    @DELETE("v1/familysync/item/{id}")
    suspend fun deletarItem(
        @Path("id") id: Int
    ): Response<APIListasResponse>

    //PUTS
    @Headers(
        "Content-Type: application/json"
    )
    @PUT("v1/familysync/lista/favorita/{id}")
    suspend fun atualizarFavorita(
        @Path("id") id: Int,
        @Body request: FavoritaRequest
    ): Response<APIListasResponse>

    @Headers(
        "Content-Type: application/json"
    )
    @PUT("v1/familysync/item/{id}")
    suspend fun atualizarItem(
        @Path("id") id: Int,
        @Body request: AtualizarItemRequest
    ): Response<AtualizarItemResponse>

    @Headers("Content-Type: application/json")
    @PUT("v1/familysync/lista/{id}")
    suspend fun atualizarLista(
        @Path("id") id: Int,
        @Body request: AtualizarListaRequest
    ): Response<APIListasResponse>
}