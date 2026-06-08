package com.aulasandroid.familysync.features.editar_financas.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.adicionar_financas.model.CriarFinancaRequest
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaEditarFinancasViewModel : ViewModel() {

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
                            id_familia = 1,
                            tipo = "despesa",
                            descricao = tema,
                            valor = valorParaApi(),
                            icone = categoriaSelecionada!!.icon
                        )
                    )

                Log.d("API_FAMILY", "HTTP: ${response.code()}")
                Log.d("API_FAMILY", "BODY: ${response.body()}")

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