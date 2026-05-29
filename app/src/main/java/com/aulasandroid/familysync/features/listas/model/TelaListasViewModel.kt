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

                        val listasOrdenadas =
                            usuario.listas.sortedByDescending {

                                it.favorita
                            }

                        listasOrdenadas.forEach { lista ->

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

    fun atualizarFavorita(
        idLista: Int,
        favorita: Boolean
    ) {

        viewModelScope.launch {

            try {

                val request =
                    FavoritaRequest(
                        favorita = favorita
                    )

                val response =
                    RetrofitFactory
                        .listasService
                        .atualizarFavorita(
                            idLista,
                            request
                        )

                if (response.isSuccessful) {

                    val index =
                        listaListas.indexOfFirst {

                            it.idLista == idLista
                        }

                    if (index != -1) {

                        val listaAtualizada =
                            listaListas[index].copy(

                                favorita =
                                    if (favorita) 1 else 0
                            )

                        listaListas[index] =
                            listaAtualizada
                    }

                    ordenarListas()
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun deletarLista(
        idLista: Int
    ) {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .listasService
                        .deletarLista(idLista)

                if (response.isSuccessful) {

                    listaListas.removeAll {

                        it.idLista == idLista
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun ordenarListas() {

        val listasOrdenadas =
            listaListas.sortedByDescending {

                it.favorita
            }

        listaListas.clear()

        listaListas.addAll(
            listasOrdenadas
        )
    }
}