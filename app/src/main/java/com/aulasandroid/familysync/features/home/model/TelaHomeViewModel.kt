package com.aulasandroid.familysync.features.home.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaHomeViewModel : ViewModel() {

    var nomeFamilia =
        mutableStateOf("")

    var carregando =
        mutableStateOf(true)
        private set

    init {
        buscarFamilia()
    }

    private fun buscarFamilia() {

        viewModelScope.launch {

            carregando.value = true

            try {

                val response =
                    RetrofitFactory
                        .homeService
                        .buscarFamilia(39)

                if (response.isSuccessful) {

                    val familia =
                        response.body()
                            ?.response
                            ?.familia
                            ?.firstOrNull()

                    nomeFamilia.value =
                        familia?.nome ?: ""
                }

            } catch (e: Exception) {

                e.printStackTrace()

            } finally {

                carregando.value = false
            }
        }
    }
}