package com.aulasandroid.familysync.features.listas.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaListasViewModel : ViewModel() {

    var listaListas =
        mutableStateListOf<ListaResponseItem>()

    var listaUsuarios =
        mutableStateListOf<UsuarioLista>()

    var listaItems =
        mutableStateListOf<ItemResponse>()

    init {
        buscarListas()
    }

    fun buscarListas() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .listasService
                        .buscarListas()

                if (response.isSuccessful) {

                    response.body()?.Response?.let {

                        listaListas.clear()
                        listaListas.addAll(it.listas)

                        listaUsuarios.clear()
                        listaUsuarios.addAll(it.usuarios)

                        listaItems.clear()
                        listaItems.addAll(it.items)
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
            ?.nome_criado
            ?: "Usuário"
    }
}