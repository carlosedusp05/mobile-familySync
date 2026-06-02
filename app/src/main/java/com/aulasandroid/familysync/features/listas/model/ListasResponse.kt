package com.aulasandroid.familysync.features.listas.model


data class APIListasResponse(
    val Desenvolvedor: String?,
    val Version: String?,
    val StatusCode: Int,
    val Response: String?
)
data class ListaComUsuario(
    val idLista: Int,
    val nomeLista: String,
    val idUsuario: Int,
    val nomeUsuario: String,
    val favorita: Int,
    val itens: List<ItemResponse>
)

data class FamiliaCompletaListasResponse(
    val Desenvolvedor: String,
    val Version: String,
    val StatusCode: Int,
    val Response: FamiliaResponse
)

data class FamiliaResponse(
    val id_familia: Int,
    val nome_familia: String,
    val usuarios: List<UsuarioFamilia>
)

data class UsuarioFamilia(
    val id_usuario: Int,
    val nome_usuario: String,
    val email: String,
    val is_admin: Int,
    val listas: List<ListaFamilia>
)

data class ListaFamilia(
    val id_lista: Int,
    val nome_lista: String,
    val favorita: Int,
    val itens: List<ItemResponse>
)

    data class ItemResponse(
    val id_item: Int,
    val nome_item: String,
    val quantidade: Int,
    val valor_unitario: String,
    val valor_total: String?,
    val comprado: Int
)

