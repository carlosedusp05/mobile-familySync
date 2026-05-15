package com.aulasandroid.familysync.features.cadastro_usuario.model

data class UsuarioRequest (
    val nome: String,
    val dataNascimento: String,
    val cpf: String,
    val email: String,
    val senha: String
)