package com.aulasandroid.familysync.retrofit

import com.aulasandroid.familysync.features.cadastro_usuario.service.CadastrarUsuarioService
import com.aulasandroid.familysync.features.despesas.service.DespesaService
import com.aulasandroid.familysync.features.eventos.service.EventosService
import com.aulasandroid.familysync.features.login.service.LoginService
import com.aulasandroid.familysync.features.eventos.users.service.UsuarioService
import com.aulasandroid.familysync.features.home.service.HomeService
import com.aulasandroid.familysync.features.informacoes_familiar.service.InformacoesService
import com.aulasandroid.familysync.features.listas.service.ListasService
import com.aulasandroid.familysync.features.notificacao.service.NotificacaoService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue
import kotlin.jvm.java

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

    val cadastrarUsuarioService: CadastrarUsuarioService by lazy {
        retrofit.create(CadastrarUsuarioService::class.java)
    }

    val despesaService: DespesaService by lazy {
        retrofit.create(DespesaService::class.java)
    }

    val loginService: LoginService by lazy {

        retrofit.create(LoginService::class.java)
    }

    val eventosService: EventosService by lazy {

        retrofit.create(EventosService::class.java)
    }

    val usuarioService: UsuarioService by lazy {

        retrofit.create(UsuarioService::class.java)
    }

    val listasService: ListasService by lazy {
        retrofit.create(ListasService::class.java)
    }

    val notificacaoService: NotificacaoService by lazy {
        retrofit.create(NotificacaoService::class.java)
    }

    val homeService: HomeService by lazy {
        retrofit.create(HomeService::class.java)
    }

    val informacoesService: InformacoesService by lazy {
        retrofit.create(InformacoesService::class.java)
    }
}