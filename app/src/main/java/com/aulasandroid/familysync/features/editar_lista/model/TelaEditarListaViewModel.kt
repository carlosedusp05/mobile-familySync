package com.aulasandroid.familysync.features.editar_lista.model

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.listas.model.ItemResponse
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaEditarListaViewModel : ViewModel() {

    var nomeLista =
        mutableStateOf("")

    var nomeOriginalLista =
        mutableStateOf("")

    var nomeItem =
        mutableStateOf("")

    var usarPreco =
        mutableStateOf(false)

    var precoItem =
        mutableStateOf("")

    var quantidadeItem =
        mutableStateOf("1")

    var itensLista =
        mutableStateListOf<ItemResponse>()

    var itensParaExcluir =
        mutableStateListOf<Int>()

    var idListaAtual = 0

    fun alterarNomeLista(
        valor: String
    ) {

        if (valor.length <= 20) {

            nomeLista.value = valor
        }
    }

    fun alterarNomeItem(
        valor: String
    ) {

        if (valor.length <= 11) {

            nomeItem.value = valor
        }
    }

    fun alterarPreco(
        valor: String
    ) {
        precoItem.value = valor
    }

    fun alterarQuantidade(
        valor: String
    ) {

        quantidadeItem.value = valor
    }

    fun alterarUsarPreco(
        valor: Boolean
    ) {

        usarPreco.value = valor
    }

    fun alternarUsarPreco() {

        usarPreco.value =
            !usarPreco.value
    }

    fun carregarLista(
        idLista: Int
    ) {

        idListaAtual = idLista

        Log.d(
            "API_FAMILY",
            "ID recebido: $idLista"
        )

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .listasService
                        .buscarFamiliaCompleta(1)

                Log.d(
                    "API_FAMILY",
                    "Código HTTP: ${response.code()}"
                )

                if (response.isSuccessful) {

                    val body = response.body()

                    Log.d(
                        "API_FAMILY",
                        "Body: $body"
                    )

                    val usuarios =
                        body?.Response?.usuarios
                            ?: emptyList()

                    Log.d(
                        "EDITAR_LISTA",
                        "Usuários encontrados: ${usuarios.size}"
                    )

                    usuarios.forEach { usuario ->

                        Log.d(
                            "API_FAMILY",
                            "Usuario: ${usuario.nome_usuario}"
                        )

                        usuario.listas.forEach { lista ->

                            Log.d(
                                "API_FAMILY",
                                """
                            Lista:
                            id=${lista.id_lista}
                            nome=${lista.nome_lista}
                            itens=${lista.itens.size}
                            """.trimIndent()
                            )
                        }
                    }

                    val lista =
                        usuarios
                            .flatMap {
                                it.listas
                            }
                            .find {
                                it.id_lista == idLista
                            }

                    Log.d(
                        "API_FAMILY",
                        "Lista encontrada: $lista"
                    )

                    nomeOriginalLista.value =
                        lista?.nome_lista ?: ""

                    nomeLista.value = ""

                    itensLista.clear()

                    itensLista.addAll(
                        lista?.itens ?: emptyList()
                    )

                    Log.d(
                        "API_FAMILY",
                        "Itens carregados: ${itensLista.size}"
                    )

                } else {

                    Log.e(
                        "API_FAMILY",
                        "Erro HTTP: ${response.errorBody()?.string()}"
                    )
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "Exceção",
                    e
                )
            }
        }
    }

    fun adicionarItemTemporario() {

        if (nomeItem.value.isBlank()) {

            return
        }

        itensLista.add(

            ItemResponse(
                id_item = 0,
                nome_item = nomeItem.value,

                quantidade =
                    if (usarPreco.value)
                        quantidadeItem.value.toIntOrNull() ?: 1
                    else
                        0,

                valor_unitario =
                    if (usarPreco.value)
                        precoItem.value.ifBlank {
                            "0.00"
                        }
                    else
                        "0.00",

                valor_total = null,

                comprado = 0
            )
        )

        nomeItem.value = ""
        precoItem.value = ""
        quantidadeItem.value = "1"
        usarPreco.value = false
    }

    fun removerItem(
        item: ItemResponse
    ) {

        if (item.id_item != 0) {

            itensParaExcluir.add(
                item.id_item
            )
        }

        itensLista.remove(item)
    }

    fun salvarLista(
        onSuccess: () -> Unit
    ) {

        viewModelScope.launch {

            try {

                val nomeFinal =
                    if (nomeLista.value.isBlank())
                        nomeOriginalLista.value
                    else
                        nomeLista.value

                Log.d(
                    "API_FAMILY",
                    "Nome final: $nomeFinal"
                )

                val requestLista =
                    AtualizarListaRequest(
                        id_familia = 1,
                        id_usuario = 59,
                        nome = nomeFinal
                    )

                val responseLista =
                    RetrofitFactory
                        .listasService
                        .atualizarLista(
                            idListaAtual,
                            requestLista
                        )

                Log.d(
                    "API_FAMILY",
                    "Atualizar lista: ${responseLista.code()}"
                )

                itensParaExcluir.forEach { idItem ->

                    val responseDelete =
                        RetrofitFactory
                            .listasService
                            .deletarItem(idItem)

                    Log.d(
                        "API_FAMILY",
                        "Delete item $idItem -> ${responseDelete.code()}"
                    )
                }

                itensLista
                    .filter {
                        it.id_item == 0
                    }
                    .forEach { item ->

                        Log.d(
                            "API_FAMILY",
                            """
                        Criando item:
                        nome=${item.nome_item}
                        quantidade=${item.quantidade}
                        valor=${item.valor_unitario}
                        """.trimIndent()
                        )

                        val responseItem =
                            RetrofitFactory
                                .listasService
                                .criarItem(
                                    CriarItemRequest(
                                        id_lista = idListaAtual,
                                        nome_item = item.nome_item,
                                        quantidade = item.quantidade,
                                        valor_unitario = item.valor_unitario,
                                        valor_total = null,
                                        comprado = false
                                    )
                                )

                        Log.d(
                            "API_FAMILY",
                            "Criar item: ${responseItem.code()}"
                        )

                        Log.d(
                            "API_FAMILY",
                            "Resposta item: ${responseItem.body()}"
                        )
                    }

                onSuccess()

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "Erro ao salvar",
                    e
                )
            }
        }
    }
}