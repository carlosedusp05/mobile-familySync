package com.aulasandroid.familysync.features.lista.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.listas.model.ItemResponse
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaListaViewModel : ViewModel() {

    var nomeOriginalLista =
        mutableStateOf("")
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
                        .buscarFamiliaCompleta(39)

                if (response.isSuccessful) {

                    val body = response.body()

                    val usuarios =
                        body?.Response?.usuarios ?: emptyList()

                    val listaEncontrada =
                        usuarios
                            .flatMap { it.listas }
                            .find { it.id_lista == idLista }

                    val itens =
                        listaEncontrada?.itens ?: emptyList()

                    listaProdutos.clear()
                    listaProdutos.addAll(itens)

                    nomeOriginalLista.value =
                        listaEncontrada?.nome_lista ?: ""

                    nomeLista.value =
                        listaEncontrada?.nome_lista ?: ""

                    val nomesUsuarios =
                        usuarios.map {

                            it.nome_usuario
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

    fun alterarNomeLista(
        valor: String
    ) {

        if (valor.length <= 20) {

            nomeLista.value = valor
        }
    }

    fun salvarNomeLista() {

        viewModelScope.launch {

            try {

                RetrofitFactory
                    .listasService
                    .atualizarLista(
                        idListaAtual,
                        AtualizarListaRequest(
                            id_familia = 39,
                            id_usuario = 59,
                            nome = nomeLista.value
                        )
                    )

                nomeOriginalLista.value =
                    nomeLista.value

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

                        nome_item = item.nome_item,

                        quantidade = item.quantidade,

                        valor_unitario = item.valor_unitario,

                        valor_total = item.valor_total,

                        comprado = comprado
                    )

                val response =
                    RetrofitFactory
                        .listasService
                        .atualizarItem(
                            item.id_item,
                            request
                        )

                if (response.isSuccessful) {

                    val index =
                        listaProdutos.indexOfFirst {

                            it.id_item == item.id_item
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
                listaProdutos.all    {

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

    fun abrirPopupEdicao() {

        nomeLista.value =
            nomeOriginalLista.value
    }

    fun obterPrecoUnitario(item: ItemResponse): Double {

        return item.valor_unitario
            .replace(",", ".")
            .toDoubleOrNull() ?: 0.0
    }

    fun obterPrecoTotal(item: ItemResponse): Double {

        return obterPrecoUnitario(item) * item.quantidade
    }

    fun obterPrecoUnitarioFormatado(item: ItemResponse): String {

        return java.text.NumberFormat
            .getCurrencyInstance(
                java.util.Locale("pt", "BR")
            )
            .format(
                obterPrecoUnitario(item)
            )
    }

    fun obterPrecoTotalFormatado(item: ItemResponse): String {

        return java.text.NumberFormat
            .getCurrencyInstance(
                java.util.Locale("pt", "BR")
            )
            .format(
                obterPrecoTotal(item)
            )
    }
}