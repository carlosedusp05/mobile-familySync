package com.aulasandroid.familysync.features.cadastro_usuario.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    private const val BASE_URL = "https://tcc-back-q3kw.onrender.com/"

    // Criamos o interceptor configurado para o nível BODY (mostra tudo)
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Criamos o cliente OkHttp e injetamos o interceptor nele
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val api: UsuarioService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client) // Vincula o cliente aqui
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsuarioService::class.java)
    }
}