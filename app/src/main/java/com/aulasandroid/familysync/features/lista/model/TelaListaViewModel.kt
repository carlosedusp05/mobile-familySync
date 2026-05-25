package com.aulasandroid.familysync.features.lista.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.features.listas.model.ItemResponse
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaListaViewModel : ViewModel() {

    var listaProdutos =
        mutableStateListOf<ItemResponse>()

    fun buscarItens(id_lista: Int) {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .listasService
                        .buscarListas()

                if (response.isSuccessful) {

                    response.body()?.Response?.let {

                        val itensFiltrados =
                            it.items.filter { item ->

                                item.id_lista == id_lista
                            }

                        listaProdutos.clear()
                        listaProdutos.addAll(itensFiltrados)
                    }
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }
}