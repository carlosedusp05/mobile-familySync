package com.aulasandroid.familysync.features.editar_lista.model

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.listas.model.ItemResponse
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class TelaEditarListaViewModel : ViewModel() {

    var nomeItem = mutableStateOf("")

    var usarPreco = mutableStateOf(false)

    var precoItem = mutableStateOf(TextFieldValue(""))

    var quantidadeItem = mutableStateOf(TextFieldValue("1"))

    var itensLista = mutableStateListOf<ItemResponse>()

    var itensParaExcluir = mutableStateListOf<Int>()

    var idListaAtual = 0

    var carregando = mutableStateOf(false)
        private set

    fun alterarNomeItem(valor: String) {

        if (valor.length <= 11) {
            nomeItem.value = valor
        }
    }

    fun alterarPreco(valor: TextFieldValue) {

        val numeros =
            valor.text.filter { it.isDigit() }

        if (numeros.isEmpty()) {

            precoItem.value =
                TextFieldValue("")

            return
        }

        val valorFormatado =
            (numeros.toLong() / 100.0)

        val texto =
            String.format("%.2f", valorFormatado)
                .replace(".", ",")

        precoItem.value =
            TextFieldValue(
                text = texto,
                selection = TextRange(texto.length)
            )
    }

    fun alterarQuantidade(valor: TextFieldValue) {
        quantidadeItem.value = valor
    }

    fun alternarUsarPreco() {
        usarPreco.value = !usarPreco.value
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
                        .buscarFamiliaCompleta(39)

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
                            .flatMap { it.listas }
                            .find { it.id_lista == idLista }

                    Log.d(
                        "API_FAMILY",
                        "Lista encontrada: $lista"
                    )

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

        Log.d(
            "TESTE_ITEM",
            """
            usarPreco=${usarPreco.value}
            preco=${precoItem.value.text}
            quantidade=${quantidadeItem.value}
            """.trimIndent()
        )
        Log.d(
            "TESTE_ITEM",
            "usarPreco=${usarPreco.value} preco=${precoItem.value.text} quantidade=${quantidadeItem.value}"
        )

        itensLista.add(
            ItemResponse(
                id_item = 0,
                nome_item = nomeItem.value,

                quantidade =
                    if (usarPreco.value)
                        quantidadeItem.value.text.toIntOrNull() ?: 1
                    else
                        1,

                valor_unitario =
                    if (usarPreco.value)
                        precoItem.value.text
                            .replace(",", ".")
                            .ifBlank { "0.00" }
                    else
                        "0.00",

                valor_total = "0",

                comprado = 0
            )
        )

        nomeItem.value = ""
        precoItem.value = TextFieldValue("")
        quantidadeItem.value = TextFieldValue("1")
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

            carregando.value = true

            try {

                itensParaExcluir.forEach { idItem ->

                    RetrofitFactory
                        .listasService
                        .deletarItem(idItem)
                }

                itensLista
                    .filter { it.id_item == 0 }
                    .forEach { item ->

                        RetrofitFactory
                            .listasService
                            .criarItem(
                                CriarItemRequest(
                                    id_lista = idListaAtual,
                                    nome_item = item.nome_item,
                                    quantidade = item.quantidade,
                                    valor_unitario = item.valor_unitario,
                                    valor_total = "0",
                                    comprado = false
                                )
                            )
                    }

                onSuccess()

            } catch (e: Exception) {

                carregando.value = false

                Log.e(
                    "API_FAMILY",
                    "Erro ao salvar",
                    e
                )
            }
        }
    }
}