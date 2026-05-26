package com.aulasandroid.familysync.features.notificacao.service
import com.aulasandroid.familysync.features.notificacao.model.NotificacaoResponse
import retrofit2.Response
import retrofit2.http.GET

interface NotificacaoService {

    @GET("v1/familysync/notificacao/4")
    suspend fun buscarNotificacoes(): Response<NotificacaoResponse>
}