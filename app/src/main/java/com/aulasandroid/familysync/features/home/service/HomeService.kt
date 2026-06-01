package com.aulasandroid.familysync.features.home.service

import com.aulasandroid.familysync.features.home.model.FamiliaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {
    @GET("v1/familysync/familia/{id}")
    suspend fun buscarFamilia(
        @Path("id") id: Int
    ): Response<FamiliaResponse>
}