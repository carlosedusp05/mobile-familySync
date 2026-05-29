package com.aulasandroid.familysync.features.criar_lista.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaCriarListaViewModel : ViewModel() {

        var nomeLista =
            mutableStateOf("")

        fun atualizarNomeLista(
            nome: String
        ) {

            nomeLista.value = nome
        }

        fun criarLista(
            onSucesso: () -> Unit
        ) {

            viewModelScope.launch {

                try {

                    val request =
                        CriarListaRequest(

                            id_familia = 1,

                            id_usuario = 59,

                            nome = nomeLista.value
                        )

                    val response =
                        RetrofitFactory
                            .listasService
                            .criarLista(request)

                    if (
                        response.isSuccessful &&
                        response.body()?.Status == true
                    ) {

                        onSucesso()
                    }

                } catch (e: Exception) {

                    e.printStackTrace()
                }
            }
        }
    }
