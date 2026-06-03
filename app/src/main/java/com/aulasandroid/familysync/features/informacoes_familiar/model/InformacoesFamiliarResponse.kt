package com.aulasandroid.familysync.features.informacoes_familiar.model

data class InformacoesFamiliaResponse(
    val status_code: Int,
    val dados: DadosFamilia
)

data class DadosFamilia(
    val id_familia: Int,
    val nome_familia: String,
    val usuarios: List<UsuarioInformacao>
)

data class BuscarInformacoesFamiliaResponse(
    val status_code: Int,
    val dados: DadosFamilia
)
