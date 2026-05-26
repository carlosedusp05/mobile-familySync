package com.aulasandroid.familysync.features.notificacao.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaNotificacaoViewModel : ViewModel() {

    var listaNotificacoes by mutableStateOf<List<Notificacao>>(emptyList())
        private set

    var carregando by mutableStateOf(false)
        private set

    var erro by mutableStateOf("")
        private set

    fun buscarNotificacoes() {

        viewModelScope.launch {

            try {

                carregando = true
                erro = ""

                val response =
                    RetrofitFactory.notificacaoService.buscarNotificacoes()

                Log.d("API_FAMILY", "CODE: ${response.code()}")
                Log.d("API_FAMILY", "BODY: ${response.body()}")

                val body = response.body()

                if (
                    response.isSuccessful &&
                    body != null
                ) {

                    listaNotificacoes = body.notificacoes

                    Log.d(
                        "API_FAMILY",
                        "TOTAL: ${body.notificacoes.size}"
                    )

                } else {

                    erro = "Erro ao buscar notificações"

                    Log.e(
                        "API_FAMILY",
                        "Erro API"
                    )
                }

            } catch (e: Exception) {

                erro = "Erro de conexão"

                Log.e(
                    "API_FAMILY",
                    "Erro conexão",
                    e
                )

            } finally {

                carregando = false
            }
        }
    }
}