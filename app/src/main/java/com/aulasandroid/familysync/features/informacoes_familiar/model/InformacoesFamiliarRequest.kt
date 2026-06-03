package com.aulasandroid.familysync.features.informacoes_familiar.model

data class UsuarioInformacao(
    val id_usuario: Int,
    val nome_usuario: String,
    val email: String,
    val is_admin: Int,
    val informacoes: List<Informacao>
)

data class Informacao(
    val id_usuario_informacao: Int,
    val id_info: Int,
    val titulo: String,
    val descricao: String
)