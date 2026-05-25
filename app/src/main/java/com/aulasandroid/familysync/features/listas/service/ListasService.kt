package com.aulasandroid.familysync.features.listas.service

import com.aulasandroid.familysync.features.listas.model.ListasAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface ListasService {
    @GET("v1/familysync/lista/1")
    suspend fun buscarListas():
            Response<ListasAPIResponse>

}