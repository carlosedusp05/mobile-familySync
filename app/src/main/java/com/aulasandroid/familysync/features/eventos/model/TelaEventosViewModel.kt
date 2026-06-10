package com.aulasandroid.familysync.features.eventos.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.eventos.users.model.UsuarioResponse
import com.aulasandroid.familysync.mask.function.formatarDataInput
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaEventosViewModel : ViewModel() {

    var idEventoSelecionado by mutableStateOf(0)

    var tituloEvento by mutableStateOf("")

    var descricaoEvento by mutableStateOf("")

    var dataEvento by mutableStateOf(
        TextFieldValue("")
    )

    var horaEvento by mutableStateOf(
        TextFieldValue("")
    )

    var listaEventos =
        mutableStateListOf<EventoResponse>()

    var listaUsuarios =
        mutableStateListOf<UsuarioResponse>()

    var carregamentoFinalizado by mutableStateOf(false)
        private set

    init {

        buscarUsuarios()
        buscarEventos()
    }

    fun preencherCampos(evento: EventoResponse) {

        idEventoSelecionado =
            evento.id_eventos

        tituloEvento =
            evento.titulo.take(20)

        descricaoEvento =
            evento.descricao.take(100)

        dataEvento =
            TextFieldValue(
                formatarDataInput(
                    evento.data
                )
            )

        horaEvento =
            TextFieldValue(
                evento.hora.substring(0, 5)
            )
    }

    fun onTituloEventoChange(
        novoTitulo: String
    ) {

        tituloEvento =
            novoTitulo.take(20)
    }

    fun onDescricaoEventoChange(
        novaDescricao: String
    ) {

        descricaoEvento =
            novaDescricao.take(100)
    }

    fun onDataEventoChange(
        novaData: TextFieldValue
    ) {

        val numeros =
            novaData.text
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

        dataEvento =
            TextFieldValue(
                text = formatado,
                selection = TextRange(
                    formatado.length
                )
            )
    }

    fun onHoraEventoChange(
        novaHora: TextFieldValue
    ) {

        val numeros =
            novaHora.text
                .filter { it.isDigit() }
                .take(4)

        var hora = ""
        var minuto = ""

        if (numeros.length >= 2) {

            hora =
                numeros.substring(0, 2)

            if (hora.toInt() > 23) {

                hora = "23"
            }

        } else {

            hora = numeros
        }

        if (numeros.length > 2) {

            minuto =
                numeros.substring(2)

            if (
                minuto.isNotEmpty() &&
                minuto.toInt() > 59
            ) {

                minuto = "59"
            }
        }

        val formatado = when {

            numeros.length <= 2 ->
                hora

            else ->
                "$hora:$minuto"
        }

        horaEvento =
            TextFieldValue(
                text = formatado,
                selection = TextRange(
                    formatado.length
                )
            )
    }

    fun atualizarEvento(
        onSucesso: () -> Unit
    ) {

        viewModelScope.launch {

            try {

                val request =
                    AtualizarEventoRequest(

                        titulo = tituloEvento,

                        descricao =
                            descricaoEvento,

                        data =
                            dataEvento.text,

                        hora =
                            horaEvento.text
                    )

                Log.d(
                    "API_FAMILY",
                    "PUT REQUEST: $request"
                )

                val response =
                    RetrofitFactory
                        .eventosService
                        .atualizarEvento(
                            idEventoSelecionado,
                            request
                        )

                Log.d(
                    "API_FAMILY",
                    "PUT CODE: ${response.code()}"
                )

                Log.d(
                    "API_FAMILY",
                    "PUT BODY: ${response.body()}"
                )

                val body = response.body()

                if (
                    response.isSuccessful &&
                    body?.StatusCode == 200
                ) {

                    onSucesso()

                } else {

                    Log.e(
                        "API_FAMILY",
                        "ERRO PUT: ${
                            response.errorBody()?.string()
                        }"
                    )
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "ERRO PUT",
                    e
                )
            }
        }
    }

    fun buscarEventos() {

        viewModelScope.launch {

            try {

                carregamentoFinalizado = false

                val response =
                    RetrofitFactory
                        .eventosService
                        .buscarEventos()

                if (response.isSuccessful) {

                    response.body()?.Response?.let {

                        listaEventos.clear()

                        listaEventos.addAll(it)
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()

            } finally {

                carregamentoFinalizado = true
            }
        }
    }

    fun buscarUsuarios() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .usuarioService
                        .buscarUsuarios()

                if (response.isSuccessful) {

                    response.body()?.Response?.let {

                        listaUsuarios.clear()

                        listaUsuarios.addAll(it)
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun buscarNomeUsuario(
        idUsuario: Int
    ): String {

        return listaUsuarios
            .find {

                it.id_usuario == idUsuario
            }
            ?.nome
            ?: "Usuário"
    }

    fun deletarEvento(
        id: Int,
        onSucesso: () -> Unit
    ) {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .eventosService
                        .deletarEvento(id)

                Log.d(
                    "API_FAMILY",
                    "DELETE CODE: ${response.code()}"
                )

                Log.d(
                    "API_FAMILY",
                    "DELETE BODY: ${response.body()}"
                )

                val body = response.body()

                if (
                    response.isSuccessful &&
                    body?.StatusCode == 200
                ) {

                    Log.d(
                        "API_FAMILY",
                        body.Response
                    )

                    onSucesso()

                } else {

                    Log.e(
                        "API_FAMILY",
                        "ERRO AO DELETAR"
                    )
                }

            } catch (e: Exception) {

                Log.e(
                    "API_FAMILY",
                    "ERRO CONEXAO DELETE",
                    e
                )
            }
        }
    }
}