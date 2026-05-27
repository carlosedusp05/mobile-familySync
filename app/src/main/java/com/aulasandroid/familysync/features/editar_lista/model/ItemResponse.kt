package com.aulasandroid.familysync.features.editar_lista.model
import com.google.gson.annotations.SerializedName

data class ItemLista(
    val id_item: Int? = null,
    val nome: String,
    val quantidade: Int,
    val valorUnitario: Double,
    val comprado: Boolean,
    val veioDaApi: Boolean = false
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

data class BuscarItensResponse(

    @SerializedName("Desenvolvedor")
    val desenvolvedor: String,

    @SerializedName("Version")
    val version: String,

    @SerializedName("StatusCode")
    val statusCode: Int,

    @SerializedName("Response")
    val response: List<ItemResponse>
)

data class ItemResponse(

    @SerializedName("id_item")
    val id_item: Int,

    @SerializedName("nome_item")
    val nome_item: String,

    @SerializedName("quantidade")
    val quantidade: Int,

    @SerializedName("valor_unitario")
    val valor_unitario: String,

    @SerializedName("comprado")
    val comprado: Boolean
)