package com.aulasandroid.familysync.features.cadastro_usuario.model

import com.google.gson.annotations.SerializedName

data class UsuarioRequest (
    val nome: String,
    @SerializedName("data_nascimento")
    val data_nascimento: String,
    val cpf: String,
    val email: String,
    val senha: String
)