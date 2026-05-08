package com.aulasandroid.familysync.features.login.model

import android.util.Patterns

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    // Estados dos campos
    var email by mutableStateOf("")
    var senha by mutableStateOf("")

    // Estados de erro
    var emailErro by mutableStateOf(false)
    var emailMensagem by mutableStateOf("")
    var senhaErro by mutableStateOf(false)
    var senhaMensagem by mutableStateOf("")

    // Funções de atualização (Eventos)
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

    fun validarDados(email: String, senha: String): Boolean {
        val emailValido = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val senhaRegex = "^(?=.*[A-Z]).{8,}$".toRegex()
        val senhaValida = senhaRegex.matches(senha)

        return emailValido && senhaValida

    }


        // Lógica de autenticação
    fun tentarLogar(onSucesso: () -> Unit) {
        val isEmailOk = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val senhaRegex = "^(?=.*[A-Z]).{8,}$".toRegex()
        val isSenhaOk = senhaRegex.matches(senha)

        if (isEmailOk && isSenhaOk) {
            onSucesso()
        } else {
            emailErro = !isEmailOk
            emailMensagem = if (!isEmailOk) "E-mail inválido" else ""

            senhaErro = !isSenhaOk
            senhaMensagem = if (!isSenhaOk) "Mínimo 8 caracteres e 1 maiúscula e 1 carctere especial" else ""
        }
    }
}