package com.aulasandroid.familysync.features.listas.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaListasViewModel : ViewModel() {

    var listaListas =
        mutableStateListOf<ListaComUsuario>()

    init {

        buscarListas()
    }

    fun calcularPorcentagem(lista: ListaComUsuario): Int {

        val totalItens =
            lista.itens.size

        if (totalItens == 0) {

            return 0
        }

        val itensComprados =
            lista.itens.count {

                it.comprado == 1
            }

        return (
                itensComprados * 100
                ) / totalItens
    }

    fun buscarListas() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .listasService
                        .buscarFamiliaCompleta(1)

                if (response.isSuccessful) {

                    val usuarios =
                        response.body()
                            ?.response
                            ?.usuarios ?: emptyList()

                    listaListas.clear()

                    usuarios.forEach { usuario ->

                        usuario.listas.forEach { lista ->

                            listaListas.add(

                                ListaComUsuario(
                                    idLista = lista.idLista,
                                    idUsuario = usuario.idUsuario,
                                    nomeLista = lista.nomeLista,
                                    nomeUsuario = usuario.nomeUsuario,
                                    favorita = lista.favorita,
                                    itens = lista.itens
                                )
                            )
                        }
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }
}