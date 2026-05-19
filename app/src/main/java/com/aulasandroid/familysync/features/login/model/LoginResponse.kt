package com.aulasandroid.familysync.features.login.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("Desenvolvedor") val desenvolvedor: String,
    @SerializedName("Version") val versao: String,
    @SerializedName("StatusCode") val statusCode: Int,
    @SerializedName("Response") val tokenJwt: String, //JWT
    @SerializedName("Status") val status: Boolean
)