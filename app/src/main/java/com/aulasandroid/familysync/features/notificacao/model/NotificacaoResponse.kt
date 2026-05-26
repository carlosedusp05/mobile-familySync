package com.aulasandroid.familysync.features.notificacao.model

import android.app.Notification
import com.google.gson.annotations.SerializedName

data class NotificacaoResponse(

    @SerializedName("Response")
    val notificacoes: List<Notificacao>
)

data class Notificacao(
    val id_notificacao: Int,
    val titulo: String,
    val descricao: String,
    val data: String
)