package com.aulasandroid.familysync.features.lista.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.editar_lista.model.ItemResponse
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaListaViewModel : ViewModel() {

    var listaProdutos =
        mutableStateListOf<ItemResponse>()

    var nomeLista =
        mutableStateOf("")

    var participantes =
        mutableStateOf("")

    var idListaAtual = 0

    fun buscarItens(idLista: Int) {

        idListaAtual = idLista

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .listasService
                        .buscarFamiliaCompleta(1)

                if (response.isSuccessful) {

                    val body = response.body()

                    val usuarios =
                        body?.response?.usuarios ?: emptyList()

                    val listaEncontrada =
                        usuarios
                            .flatMap { it.listas }
                            .find { it.idLista == idLista }

                    val itens =
                        listaEncontrada?.itens ?: emptyList()

                    listaProdutos.clear()
                    listaProdutos.addAll(itens)

                    nomeLista.value =
                        listaEncontrada?.nomeLista ?: ""

                    val nomesUsuarios =
                        usuarios.map {

                            it.nomeUsuario
                                .split(" ")
                                .take(2)
                                .joinToString(" ")
                        }

                    participantes.value =
                        if (nomesUsuarios.size > 4) {

                            nomesUsuarios
                                .take(4)
                                .joinToString(", ") + " ..."
                        } else {

                            nomesUsuarios
                                .joinToString(", ")
                        }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun atualizarItemComprado(
        item: ItemResponse,
        comprado: Boolean
    ) {

        viewModelScope.launch {

            try {

                val request =
                    AtualizarItemRequest(

                        id_lista = idListaAtual,

                        nome_item = item.nomeItem,

                        quantidade = item.quantidade,

                        valor_unitario = item.valorUnitario,

                        valor_total = item.valorTotal,

                        comprado = comprado
                    )

                val response =
                    RetrofitFactory
                        .listasService
                        .atualizarItem(
                            item.idItem,
                            request
                        )

                if (response.isSuccessful) {

                    val index =
                        listaProdutos.indexOfFirst {

                            it.idItem == item.idItem
                        }

                    if (index != -1) {

                        listaProdutos[index] =
                            listaProdutos[index].copy(

                                comprado =
                                    if (comprado) 1 else 0
                            )
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun todosSelecionados(): Boolean {

        return listaProdutos.isNotEmpty() &&
                listaProdutos.all {

                    it.comprado == 1
                }
    }

    fun alterarTodosItens() {

        val marcarTodos =
            listaProdutos.any {

                it.comprado == 0
            }

        listaProdutos.forEach { item ->

            atualizarItemComprado(
                item,
                marcarTodos
            )
        }
    }
}