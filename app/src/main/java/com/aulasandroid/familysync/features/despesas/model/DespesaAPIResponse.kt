package com.aulasandroid.familysync.features.despesas.model

import com.google.gson.annotations.SerializedName


data class DespesaAPIResponse(
    @SerializedName("Desenvolvedor") val desenvolvedor: String,
    @SerializedName("Version") val version: String,
    @SerializedName("StatusCode") val statusCode: Int,
    @SerializedName("Response") val despesas: List<DespesaItem>,
    @SerializedName("Status") val status: Boolean
)

data class DespesaItem(
    @SerializedName("id_financas") val idDespesa: Int,
    @SerializedName("id_familia") val idFamilia: Int,
    val tipo: String,
    val descricao: String,
    val valor: String,
    @SerializedName("data_movimentacao") val dataMovimentacao: String,
    val icone: String
)
