package com.aulasandroid.familysync.features.adicionar_financas.model

data class CriarFinancaResponse(
    val Desenvolvedor: String,
    val Version: String,
    val StatusCode: Int,
    val Response: String,
    val Status: Boolean
)

data class CriarFinancaRequest(
    val id_familia: Int,
    val tipo: String,
    val descricao: String,
    val valor: Double,
    val icone: String
)