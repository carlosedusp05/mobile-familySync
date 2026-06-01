package com.aulasandroid.familysync.features.home.model

import com.google.gson.annotations.SerializedName

data class FamiliaResponse(

    @SerializedName("Response")
    val response: FamiliaDados
)

data class FamiliaDados(

    @SerializedName("familia")
    val familia: List<FamiliaItem>
)

data class FamiliaItem(

    @SerializedName("id_familia")
    val idFamilia: Int,

    @SerializedName("nome")
    val nome: String
)