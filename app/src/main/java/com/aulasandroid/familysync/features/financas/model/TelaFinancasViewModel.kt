package com.aulasandroid.familysync.features.financas.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaFinancasViewModel : ViewModel() {

    var periodoSelecionado by mutableStateOf(Periodo.DIA)
        private set

    var totalGastoFormatado by mutableStateOf("R$ 0,00")
        private set

    var listaItensTela = mutableStateListOf<ItemTelaFinanca>()
        private set

    var carregando by mutableStateOf(true)
        private set

    fun carregarDados() {
        carregarPeriodo(periodoSelecionado)
    }

    fun deletarFinanca(
        idFinanca: Int
    ) {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory.financasService
                        .deletarFinanca(idFinanca)

                Log.d(
                    "API_FAMILY",
                    "DELETE HTTP: ${response.code()}"
                )

                if (response.isSuccessful) {

                    listaItensTela.removeAll {
                        it.id == idFinanca
                    }

                    carregarPeriodo(periodoSelecionado)
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "Erro ao deletar",
                    e
                )

            }
        }
    }

    fun carregarPeriodo(periodo: Periodo) {

        periodoSelecionado = periodo

        viewModelScope.launch {

            carregando = true

            try {

                val response = when (periodo) {

                    Periodo.DIA ->
                        RetrofitFactory.financasService.buscarFinancasDiarias(39)

                    Periodo.SEMANA ->
                        RetrofitFactory.financasService.buscarFinancasSemanais(39)

                    Periodo.MES ->
                        RetrofitFactory.financasService.buscarFinancasMensais(39)

                    Periodo.ANO ->
                        RetrofitFactory.financasService.buscarFinancasAnuais(39)
                }

                if (response.isSuccessful) {

                    listaItensTela.clear()

                    when (periodo) {

                        Periodo.DIA -> {

                            val response =
                                RetrofitFactory.financasService.buscarFinancasDiarias(39)

                            if (response.isSuccessful) {

                                val financas =
                                    response.body()?.Response?.financas ?: emptyList()

                                listaItensTela.clear()

                                listaItensTela.addAll(
                                    financas.map {
                                        ItemTelaFinanca(
                                            id = it.id_financas,
                                            titulo = it.descricao ?: "",
                                            icone = it.icone ?: "💰",
                                            valor = it.valor ?: "0"
                                        )
                                    }
                                )

                                val total = financas.sumOf {
                                    it.valor?.toDoubleOrNull() ?: 0.0
                                }

                                totalGastoFormatado = "R$ %.2f".format(total)
                            }
                        }

                        Periodo.SEMANA -> {

                            val response =
                                RetrofitFactory.financasService.buscarFinancasSemanais(39)

                            if (response.isSuccessful) {

                                val financas =
                                    response.body()?.Response?.financas ?: emptyList()

                                listaItensTela.clear()

                                listaItensTela.addAll(
                                    financas.map {
                                        ItemTelaFinanca(
                                            titulo = it.dia_semana ?: "",
                                            icone = "🗓️",
                                            valor = it.total ?: "0"
                                        )
                                    }
                                )
                            }
                        }

                        Periodo.MES -> {

                            val response =
                                RetrofitFactory.financasService.buscarFinancasMensais(39)

                            if (response.isSuccessful) {

                                val financas =
                                    response.body()?.Response?.financas ?: emptyList()

                                listaItensTela.clear()

                                listaItensTela.addAll(
                                    financas.map {
                                        ItemTelaFinanca(
                                            titulo = it.semana_mes ?: "",
                                            icone = "🗓️",
                                            valor = it.total ?: "0"
                                        )
                                    }
                                )
                            }
                        }

                        Periodo.ANO -> {

                            val response =
                                RetrofitFactory.financasService.buscarFinancasAnuais(39)

                            if (response.isSuccessful) {

                                val financas =
                                    response.body()?.Response?.financas ?: emptyList()

                                listaItensTela.clear()

                                listaItensTela.addAll(
                                    financas.map {
                                        ItemTelaFinanca(
                                            id = it.id_familia,
                                            titulo = it.mes ?: "",
                                            icone = "📅",
                                            valor = it.total ?: "0"
                                        )
                                    }
                                )
                            }
                        }
                    }
                }

            } catch (e: Exception) {

                Log.e("API_FAMILY", "Erro", e)

            } finally {
                carregando = false
            }
        }
    }
}