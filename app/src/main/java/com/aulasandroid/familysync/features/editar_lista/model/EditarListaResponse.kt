package com.aulasandroid.familysync.features.editar_lista.model

import com.google.gson.annotations.SerializedName

data class FamiliaCompletaResponse(

    @SerializedName("Desenvolvedor")
    val desenvolvedor: String,

    @SerializedName("Version")
    val version: String,

    @SerializedName("StatusCode")
    val statusCode: Int,

    @SerializedName("Response")
    val response: FamiliaResponse,

    @SerializedName("Status")
    val status: Boolean
)

data class FamiliaResponse(

    @SerializedName("id_familia")
    val idFamilia: Int,

    @SerializedName("nome_familia")
    val nomeFamilia: String,

    @SerializedName("usuarios")
    val usuarios: List<UsuarioResponse>
)

data class UsuarioResponse(

    @SerializedName("id_usuario")
    val idUsuario: Int,

    @SerializedName("nome_usuario")
    val nomeUsuario: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("is_admin")
    val isAdmin: Int,

    @SerializedName("listas")
    val listas: List<ListaResponse>
)

data class ListaResponse(

    @SerializedName("id_lista")
    val idLista: Int,

    @SerializedName("nome_lista")
    val nomeLista: String,

    @SerializedName("itens")
    val itens: List<ItemResponse>
)

data class ItemResponse(

    @SerializedName("id_item")
    val idItem: Int,

    @SerializedName("nome_item")
    val nomeItem: String,

    @SerializedName("quantidade")
    val quantidade: Int,

    @SerializedName("valor_unitario")
    val valorUnitario: String,

    @SerializedName("valor_total")
    val valorTotal: String?,

    @SerializedName("comprado")
    val comprado: Int
)

data class ItemLista(

    val id_item: Int? = null,

    val nome: String,

    val quantidade: Int,

    val valorUnitario: Double,

    val comprado: Boolean,

    val veioDaApi: Boolean = false
)

data class DeleteItemResponse(

    @SerializedName("Desenvolvedor")
    val desenvolvedor: String,

    @SerializedName("Version")
    val version: String,

    @SerializedName("StatusCode")
    val statusCode: Int,

    @SerializedName("Response")
    val response: String
)

data class CriarItemResponse(

    @SerializedName("Desenvolvedor")
    val desenvolvedor: String,

    @SerializedName("Version")
    val version: String,

    @SerializedName("StatusCode")
    val statusCode: Int,

    @SerializedName("Response")
    val response: String
)