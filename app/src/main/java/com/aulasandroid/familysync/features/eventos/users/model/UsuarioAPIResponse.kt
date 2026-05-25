package com.aulasandroid.familysync.features.eventos.users.model

data class UsuariosAPIResponse(

    val Response: List<UsuarioResponse>
)

data class UsuarioResponse(
    val id_usuario: Int,
    val nome: String,
    val cpf: String,
    val data_nascimento: String,
    val email: String,
    val senha: String
)