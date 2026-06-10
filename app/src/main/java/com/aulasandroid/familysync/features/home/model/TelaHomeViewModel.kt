package com.aulasandroid.familysync.features.home.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class TelaHomeViewModel : ViewModel() {

    var nomeFamilia =
        mutableStateOf("")

    init {

        buscarFamilia()
    }

    fun buscarFamilia() {

        viewModelScope.launch {

            try {

                val response =
                    RetrofitFactory
                        .homeService
                        .buscarFamilia(39)

                if (response.isSuccessful) {

                    nomeFamilia.value =
                        response.body()
                            ?.response
                            ?.familia
                            ?.firstOrNull()
                            ?.nome ?: ""
                }

            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }
}