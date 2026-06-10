package com.aulasandroid.familysync.features.calendario.model

import android.util.Log
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.eventos.model.EventoRequest
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
class TelaCalendarioViewModel : ViewModel() {

    var titulo by mutableStateOf("")
    var descricao by mutableStateOf("")
    var data by mutableStateOf(
        TextFieldValue("")
    )

    var hora by mutableStateOf(
        TextFieldValue("")
    )

    fun onDataChange(novaData: TextFieldValue) {

        val numeros = novaData.text
            .filter { it.isDigit() }
            .take(8)

        val formatado = when {

            numeros.length <= 4 ->
                numeros

            numeros.length <= 6 ->
                "${numeros.substring(0, 4)}-" +
                        numeros.substring(4)

            else ->
                "${numeros.substring(0, 4)}-" +
                        "${numeros.substring(4, 6)}-" +
                        numeros.substring(6)
        }

        data = TextFieldValue(
            text = formatado,
            selection = TextRange(formatado.length)
        )
    }

    fun onHoraChange(novaHora: TextFieldValue) {

        val numeros = novaHora.text
            .filter { it.isDigit() }
            .take(4)

        val formatado = when {

            numeros.length <= 2 ->
                numeros

            else ->
                "${numeros.substring(0, 2)}:" +
                        numeros.substring(2)
        }

        hora = TextFieldValue(
            text = formatado,
            selection = TextRange(formatado.length)
        )
    }

    fun onTituloChange(novoTitulo: String) {

        titulo = novoTitulo.take(20)
    }

    fun onDescricaoChange(novaDescricao: String) {

        descricao = novaDescricao.take(100)
    }



    val datePickerState = DatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
        locale = Locale.getDefault(),
        initialDisplayedMonthMillis = System.currentTimeMillis(),
        yearRange = IntRange(2024, 2100),
        initialDisplayMode = DisplayMode.Picker
    )

    fun getDataSelecionada(): Long? {
        return datePickerState.selectedDateMillis
    }

    fun criarEvento(
        onSucesso: () -> Unit
    ) {

        viewModelScope.launch {

            try {

                val request = EventoRequest(
                    id_eventos = 0,
                    id_familia = 39,
                    id_usuario = 98,
                    titulo = titulo,
                    descricao = descricao,
                    data = data.text,
                    hora = hora.text
                )

                Log.d("API_FAMILY", "ENVIANDO: $request")

                val response =
                    RetrofitFactory.eventosService.criarEvento(request)

                Log.d("API_FAMILY", "CODE: ${response.code()}")
                Log.d("API_FAMILY", "BODY: ${response.body()}")

                val body = response.body()

                if (
                    response.isSuccessful &&
                    body?.StatusCode == 201

                ) {

                    Log.d(
                        "API_FAMILY",
                        "EVENTO CRIADO"
                    )

                    onSucesso()

                } else {

                    Log.e(
                        "API_FAMILY",
                        "ERRO API"
                    )
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "ERRO CONEXAO",
                    e
                )
            }
        }
    }
}