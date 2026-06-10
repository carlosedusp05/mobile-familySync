package com.aulasandroid.familysync.features.editar_financas.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.adicionar_financas.model.CategoriaFinanca
import com.aulasandroid.familysync.features.adicionar_financas.model.CriarFinancaRequest
import com.aulasandroid.familysync.features.adicionar_financas.model.categorias
import com.aulasandroid.familysync.features.financas.model.ItemTelaFinanca
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaEditarFinancasViewModel : ViewModel() {

    var tema by mutableStateOf("")
        private set

    var valor by mutableStateOf("")
        private set

    var categoriaSelecionada by mutableStateOf<CategoriaFinanca?>(null)
        private set

    var carregando by mutableStateOf(false)
        private set

    fun carregarFinanca(
        idFinanca: Int
    ) {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory.financasService
                        .buscarFinancaPorId(idFinanca)

                Log.d("EDITAR", "HTTP: ${response.code()}")
                Log.d("EDITAR", "BODY: ${response.body()}")

                if (
                    response.isSuccessful &&
                    response.body()?.StatusCode == 200
                ) {

                    val item =
                        response.body()
                            ?.Response
                            ?.firstOrNull()

                    item?.let {

                        tema = it.descricao

                        valor = it.valor
                            .replace(".", ",")

                        categoriaSelecionada =
                            categorias.find { categoria ->
                                categoria.icon == it.icone
                            }
                    }
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "Erro ao carregar despesa",
                    e
                )
            }
        }
    }


        fun alterarTema(
        novoTema: String
    ) {

        if (novoTema.length <= 20) {
            tema = novoTema
        }
    }

    fun alterarValor(
        novoValor: String
    ) {

        var texto = novoValor.replace(".", ",")

        texto = texto.filter {
            it.isDigit() || it == ','
        }

        if (texto.count { it == ',' } > 1) {
            return
        }

        if (texto.contains(",")) {

            val partes = texto.split(",")

            if (
                partes.size == 2 &&
                partes[1].length > 2
            ) {
                return
            }
        }

        valor = texto
    }

    fun selecionarCategoria(
        categoria: CategoriaFinanca
    ) {
        categoriaSelecionada = categoria
    }

    fun valorParaApi(): Double {

        return valor
            .replace(",", ".")
            .toDoubleOrNull()
            ?: 0.0
    }

    fun formularioValido(): Boolean {

        return tema.isNotBlank() &&
                valor.isNotBlank() &&
                categoriaSelecionada != null
    }

    fun atualizarFinanca(
        idFinanca: Int,
        onSuccess: () -> Unit
    ) {

        if (!formularioValido()) {
            return
        }

        viewModelScope.launch {

            try {

                carregando = true

                val response =
                    RetrofitFactory.financasService.atualizarFinanca(
                        idFinanca = idFinanca,
                        request = CriarFinancaRequest(
                            id_familia = 39,
                            tipo = "despesa",
                            descricao = tema,
                            valor = valorParaApi(),
                            icone = categoriaSelecionada!!.icon
                        )
                    )

                Log.d(
                    "API_FAMILY",
                    "HTTP: ${response.code()}"
                )

                Log.d(
                    "API_FAMILY",
                    "BODY: ${response.body()}"
                )

                if (
                    response.isSuccessful &&
                    response.body()?.StatusCode == 200
                ) {
                    onSuccess()
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "Erro ao atualizar",
                    e
                )

            } finally {

                carregando = false
            }
        }
    }
}