package com.aulasandroid.familysync.Retrofit

import com.aulasandroid.familysync.features.cadastro_usuario.service.UsuarioService
import com.aulasandroid.familysync.features.despesas.service.DespesaService
import com.aulasandroid.familysync.features.login.service.LoginService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private const val BASE_URL =
        "https://tcc-back-q3kw.onrender.com/"

    private val loggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val usuarioService: UsuarioService by lazy {
        retrofit.create(UsuarioService::class.java)
    }

    val despesaService: DespesaService by lazy {
        retrofit.create(DespesaService::class.java)
    }

    val loginService: LoginService by lazy {

        retrofit.create(LoginService::class.java)
    }
}