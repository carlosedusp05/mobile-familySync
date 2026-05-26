package com.aulasandroid.familysync.features.eventos.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import com.aulasandroid.familysync.features.eventos.users.model.UsuarioResponse

import kotlinx.coroutines.launch

class TelaEventosViewModel : ViewModel() {

    var listaEventos =
        mutableStateListOf<EventoResponse>()

    var listaUsuarios =
        mutableStateListOf<UsuarioResponse>()

    init {

        buscarUsuarios()
        buscarEventos()
    }

    fun buscarEventos() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .eventosService
                        .buscarEventos()

                if (response.isSuccessful) {

                    response.body()?.Response?.let {

                        listaEventos.clear()
                        listaEventos.addAll(it)
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun buscarUsuarios() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .usuarioService
                        .buscarUsuarios()

                if (response.isSuccessful) {

                    response.body()?.Response?.let {

                        listaUsuarios.clear()
                        listaUsuarios.addAll(it)
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun buscarNomeUsuario(idUsuario: Int): String {

        return listaUsuarios
            .find { it.id_usuario == idUsuario }
            ?.nome
            ?: "Usuário"
    }

    fun deletarEvento(
        id: Int,
        onSucesso: () -> Unit
    ) {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .eventosService
                        .deletarEvento(id)

                Log.d(
                    "API_FAMILY",
                    "DELETE CODE: ${response.code()}"
                )

                Log.d(
                    "API_FAMILY",
                    "DELETE BODY: ${response.body()}"
                )

                val body = response.body()

                if (
                    response.isSuccessful &&
                    body?.StatusCode == 200
                ) {

                    Log.d(
                        "API_FAMILY",
                        body.Response
                    )

                    onSucesso()

                } else {

                    Log.e(
                        "API_FAMILY",
                        "ERRO AO DELETAR"
                    )
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "ERRO CONEXAO DELETE",
                    e
                )
            }
        }
    }

}