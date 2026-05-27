package com.aulasandroid.familysync.features.editar_lista.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaEditarListaViewModel : ViewModel() {

    var nomeItem by mutableStateOf("")
    var valorUnitario by mutableStateOf("")
    var quantidade by mutableStateOf("")
    var comprado by mutableStateOf(false)

    var listaItens =
        mutableStateListOf<ItemLista>()

    var itensRemovidos =
        mutableStateListOf<ItemLista>()

    init {

        buscarItens(1)
    }

    fun buscarItens(idLista: Int) {

        viewModelScope.launch {

            try {

                Log.d(
                    "API_FAMILY",
                    "BUSCANDO ITENS DA LISTA: $idLista"
                )

                val response =
                    RetrofitFactory
                        .listasService
                        .buscarItens(idLista)

                Log.d(
                    "API_FAMILY",
                    "GET CODE: ${response.code()}"
                )

                Log.d(
                    "API_FAMILY",
                    "GET BODY: ${response.body()}"
                )

                if (response.isSuccessful) {

                    val body = response.body()

                    body?.response?.let { itens ->

                        listaItens.clear()

                        listaItens.addAll(

                            itens.map {

                                ItemLista(
                                    id_item = it.id_item,
                                    nome = it.nome_item,
                                    quantidade = it.quantidade,
                                    valorUnitario = it.valor_unitario.toDouble(),
                                    comprado = it.comprado,
                                    veioDaApi = true
                                )
                            }
                        )

                        Log.d(
                            "API_FAMILY",
                            "ITENS CARREGADOS: ${listaItens.size}"
                        )
                    }

                } else {

                    Log.e(
                        "API_FAMILY",
                        "ERRO GET: ${response.errorBody()?.string()}"
                    )
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "ERRO BUSCAR ITENS: ${e.message}"
                )

                e.printStackTrace()
            }
        }
    }

    fun onNomeItemChange(novoNome: String) {

        nomeItem =
            novoNome.take(20)
    }

    fun onValorUnitarioChange(novoValor: String) {

        var valorFiltrado =
            novoValor.filter {

                it.isDigit() || it == '.'
            }

        val partes =
            valorFiltrado.split(".")

        if (partes.size > 2) {

            valorFiltrado =
                partes[0] + "." + partes[1]
        }

        if (partes.size == 2) {

            valorFiltrado =
                partes[0] + "." +
                        partes[1].take(2)
        }

        valorUnitario = valorFiltrado
    }

    fun onQuantidadeChange(novaQuantidade: String) {

        quantidade =
            novaQuantidade.filter {

                it.isDigit()
            }
    }

    fun onCompradoChange() {

        comprado = !comprado
    }

    fun adicionarItem() {

        Log.d(
            "API_FAMILY",
            "TENTANDO ADICIONAR ITEM"
        )

        if (
            nomeItem.isBlank() ||
            quantidade.isBlank() ||
            valorUnitario.isBlank()
        ) {

            Log.e(
                "API_FAMILY",
                "CAMPOS VAZIOS"
            )

            return
        }

        val quantidadeInt =
            quantidade.toIntOrNull()

        val valorDouble =
            valorUnitario.toDoubleOrNull()

        if (
            quantidadeInt == null ||
            valorDouble == null
        ) {

            Log.e(
                "API_FAMILY",
                "VALORES INVALIDOS"
            )

            return
        }

        listaItens.add(

            ItemLista(
                nome = nomeItem,
                quantidade = quantidadeInt,
                valorUnitario = valorDouble,
                comprado = comprado,
                veioDaApi = false
            )
        )

        Log.d(
            "API_FAMILY",
            "ITEM ADICIONADO COM SUCESSO"
        )

        Log.d(
            "API_FAMILY",
            "TOTAL ITENS: ${listaItens.size}"
        )

        nomeItem = ""
        quantidade = ""
        valorUnitario = ""
        comprado = false
    }

    fun removerItem(item: ItemLista) {

        listaItens.remove(item)

        Log.d(
            "API_FAMILY",
            "ITEM REMOVIDO DO CARD"
        )

        if (item.veioDaApi) {

            itensRemovidos.add(item)

            Log.d(
                "API_FAMILY",
                "ITEM MARCADO PARA DELETE API"
            )
        }
    }

    fun salvarItens(idLista: Int) {

        viewModelScope.launch {

            try {

                Log.d(
                    "API_FAMILY",
                    "======================="
                )

                Log.d(
                    "API_FAMILY",
                    "INICIANDO SALVAMENTO"
                )

                Log.d(
                    "API_FAMILY",
                    "ID LISTA: $idLista"
                )

                listaItens
                    .filter { !it.veioDaApi }
                    .forEach { item ->

                        try {

                            val request =
                                CriarItemRequest(

                                    id_lista = idLista,
                                    nome_item = item.nome,
                                    quantidade = item.quantidade,
                                    valor_unitario =
                                        item.valorUnitario.toString(),
                                    valor_total = null,
                                    comprado = item.comprado
                                )

                            Log.d(
                                "API_FAMILY",
                                "POST REQUEST: $request"
                            )

                            val response =
                                RetrofitFactory
                                    .listasService
                                    .criarItem(request)

                            Log.d(
                                "API_FAMILY",
                                "POST CODE: ${response.code()}"
                            )

                            Log.d(
                                "API_FAMILY",
                                "POST BODY: ${response.body()}"
                            )

                            val erro =
                                response.errorBody()?.string()

                            Log.d(
                                "API_FAMILY",
                                "POST ERROR: $erro"
                            )

                        } catch (e: Exception) {

                            Log.e(
                                "API_FAMILY",
                                "ERRO POST ITEM: ${e.message}"
                            )

                            e.printStackTrace()
                        }
                    }

                itensRemovidos.forEach { item ->

                    item.id_item?.let { id ->

                        try {

                            Log.d(
                                "API_FAMILY",
                                "DELETE ITEM ID: $id"
                            )

                            val response =
                                RetrofitFactory
                                    .listasService
                                    .deletarItem(id)

                            Log.d(
                                "API_FAMILY",
                                "DELETE CODE: ${response.code()}"
                            )

                            Log.d(
                                "API_FAMILY",
                                "DELETE BODY: ${response.body()}"
                            )

                            val erro =
                                response.errorBody()?.string()

                            Log.d(
                                "API_FAMILY",
                                "DELETE ERROR: $erro"
                            )

                        } catch (e: Exception) {

                            Log.e(
                                "API_FAMILY",
                                "ERRO DELETE ITEM: ${e.message}"
                            )

                            e.printStackTrace()
                        }
                    }
                }

                itensRemovidos.clear()

                Log.d(
                    "API_FAMILY",
                    "PROCESSO FINALIZADO"
                )

                Log.d(
                    "API_FAMILY",
                    "======================="
                )

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "ERRO GERAL: ${e.message}"
                )

                e.printStackTrace()
            }
        }
    }
}