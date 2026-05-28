package com.aulasandroid.familysync.features.lista.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.editar_lista.model.ItemResponse
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaListaViewModel : ViewModel() {

    var listaProdutos =
        mutableStateListOf<ItemResponse>()

    var nomeLista =
        mutableStateOf("")

    var participantes =
        mutableStateOf("")

    fun buscarItens(idLista: Int) {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .listasService
                        .buscarFamiliaCompleta(1)

                if (response.isSuccessful) {

                    val body = response.body()

                    val usuarios =
                        body?.response?.usuarios ?: emptyList()

                    val listaEncontrada =
                        usuarios
                            .flatMap { it.listas }
                            .find { it.idLista == idLista }

                    val itens =
                        listaEncontrada?.itens ?: emptyList()

                    listaProdutos.clear()
                    listaProdutos.addAll(itens)

                    nomeLista.value =
                        listaEncontrada?.nomeLista ?: ""

                    val nomesUsuarios =
                        usuarios.map {

                            it.nomeUsuario
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
}