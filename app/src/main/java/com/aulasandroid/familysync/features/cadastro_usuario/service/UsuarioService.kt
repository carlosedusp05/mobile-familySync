package com.aulasandroid.familysync.features.cadastro_usuario.service

import com.aulasandroid.familysync.features.cadastro_usuario.model.APIResponse
import com.aulasandroid.familysync.features.cadastro_usuario.model.UsuarioRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface  UsuarioService {
        @Headers(
            "Content-Type: application/json"
        )
        @POST("v1/familysync/usuario")
        suspend fun cadastrarUsuario(
            @Body usuario: UsuarioRequest
        ): Response<APIResponse>
}