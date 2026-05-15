package com.aulasandroid.familysync.features.cadastro_usuario.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    private const val BASE_URL =
        "https://tcc-back-q3kw.onrender.com/"

    val api: UsuarioService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsuarioService::class.java)
    }
}