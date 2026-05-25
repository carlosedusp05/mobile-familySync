package com.aulasandroid.familysync.features.login.model

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aulasandroid.familysync.retrofit.RetrofitFactory
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var email by mutableStateOf("")
    var senha by mutableStateOf("")

    var emailErro by mutableStateOf(false)
    var emailMensagem by mutableStateOf("")

    var senhaErro by mutableStateOf(false)
    var senhaMensagem by mutableStateOf("")

    var carregando by mutableStateOf(false)
        private set

    fun onEmailChange(novoEmail: String) {
        email = novoEmail
        emailErro = false
        emailMensagem = ""
    }

    fun onSenhaChange(novaSenha: String) {
        senha = novaSenha
        senhaErro = false
        senhaMensagem = ""
    }

    fun tentarLogar(onSucesso: () -> Unit) {

        val isEmailOk = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isSenhaOk = senha.isNotBlank()

        if (isEmailOk && isSenhaOk) {

            viewModelScope.launch {

                try {

                    carregando = true

                    val request = LoginRequest(
                        email = email,
                        senha = senha
                    )

                    Log.d("API_FAMILY", "Enviando: $request")

                    val response = RetrofitFactory.loginService.logar(request)

                    Log.d("API_FAMILY", "CODE: ${response.code()}")
                    Log.d("API_FAMILY", "BODY: ${response.body()}")
                    Log.d("API_FAMILY", "ERROR: ${response.errorBody()?.string()}")

                    val body = response.body()

                    Log.d("API_FAMILY", "BODY: $body")

                    if (response.isSuccessful &&
                        body?.status == true &&
                        body.statusCode == 200
                    ) {

                        val token = body.tokenJwt

                        Log.d("API_FAMILY", "TOKEN: $token")

                        onSucesso()

                    } else {

                        senhaErro = true
                        senhaMensagem = "E-mail ou senha incorretos"

                        Log.e("API_FAMILY", "Erro login")

                    }

                } catch (e: Exception) {

                    Log.e("API_FAMILY", "Erro conexão", e)

                    senhaErro = true
                    senhaMensagem = "Erro de conexão"

                } finally {

                    carregando = false
                }
            }



            emailErro = !isEmailOk
            emailMensagem =
                if (!isEmailOk) "E-mail inválido" else ""

            senhaErro = !isSenhaOk
            senhaMensagem =
                if (!isSenhaOk) "Digite sua senha" else ""
        }
    }
}