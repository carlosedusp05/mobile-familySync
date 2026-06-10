package com.aulasandroid.familysync.features.informacoes_familiar.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaInformacoesFamiliarViewModel : ViewModel(){

    var usuarios = mutableStateListOf<UsuarioInformacao>()

    var usuarioSelecionado =
        mutableStateOf<UsuarioInformacao?>(null)

    fun selecionarUsuario(usuario: UsuarioInformacao) {
        usuarioSelecionado.value = usuario
    }

    fun buscarInformacoesFamilia() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .informacoesService
                        .buscarInformacoesFamilia(39)

                if (response.isSuccessful) {

                    val listaUsuarios =
                        response.body()
                            ?.dados
                            ?.usuarios
                            ?: emptyList()

                    usuarios.clear()
                    usuarios.addAll(listaUsuarios)

                    if (usuarios.isNotEmpty()) {

                        usuarioSelecionado.value =
                            usuarios.first()
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }
}