package com.aulasandroid.familysync.features.despesas.model

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.Retrofit.RetrofitFactory
import com.aulasandroid.familysync.features.despesas.service.DespesaService
import kotlinx.coroutines.launch

class TelaDespesasViewModel :ViewModel() {

    private var listaDespesasBruta = emptyList<DespesaItem>()

    var totalGastoFormatado by mutableStateOf("R$ 0,00")
        private set

    var listaItensTela by mutableStateOf<List<DespesaUiState>>(emptyList())
        private set

    fun carregarDados() {
        viewModelScope.launch {
            try {
                val response = RetrofitFactory.despesaService.buscarDespesa()
                if (response.isSuccessful && response.body() != null) {
                    listaDespesasBruta = response.body()!!.despesas.filter {
                        it.tipo.lowercase() == "despesa"
                    }

                    atualizarInterface()
                }
            } catch (e: Exception) {
            }
        }
    }
    private fun atualizarInterface() {
        val totalGasto = listaDespesasBruta.sumOf { it.valor.toDoubleOrNull() ?: 0.0 }
        totalGastoFormatado = String.format("R$ %.2f", totalGasto)

        listaItensTela = listaDespesasBruta.map { despesa ->
            val valorItem = despesa.valor.toDoubleOrNull() ?: 0.0

            val porcentagemCalculada = if (totalGasto > 0) {
                (valorItem / totalGasto) * 100
            } else {
                0.0
            }

            DespesaUiState(
                titulo = despesa.descricao,
                icone = despesa.icone,
                valorFormatado = String.format("R$ %.2f", valorItem),
                porcentagem = String.format("%.0f%%", porcentagemCalculada),
                valorNumerico = valorItem.toFloat()
            )
        }
    }
}