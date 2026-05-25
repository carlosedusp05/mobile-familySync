package com.aulasandroid.familysync.features.eventos.users.service

import com.aulasandroid.familysync.features.eventos.users.model.UsuariosAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface UsuarioService {
    @GET("v1/familysync/usuarios")
    suspend fun buscarUsuarios():
            Response<UsuariosAPIResponse>
}