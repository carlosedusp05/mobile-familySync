package com.aulasandroid.familysync.features.cadastro_usuario.model


import android.util.Patterns

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class CadastroUsuarioViewModel : ViewModel() {

    // Estados dos campos
    var email by mutableStateOf("")
    // Estados de erro
    var emailErro by mutableStateOf(false)
    var emailMensagem by mutableStateOf("")


    // Funções de atualização (Eventos)
    fun onEmailChange(novoEmail: String) {
        email = novoEmail
        emailErro = false
        emailMensagem = ""
    }


    var senha by mutableStateOf("")
    var senhaErro by mutableStateOf(false)
    var senhaMensagem by mutableStateOf("")

    fun onSenhaChange(novaSenha: String) {
        senha = novaSenha
        senhaErro = false
        senhaMensagem = ""
    }

    var nome by mutableStateOf("")
    var nomeErro by mutableStateOf(false)
    var nomeMensagem by mutableStateOf("")

    fun onNomeChange(novoNome: String) {
        nome = novoNome
        nomeErro = false
        nomeMensagem = ""
    }

    var cpf by mutableStateOf("")
    var cpfErro by mutableStateOf(false)
    var cpfMensagem by mutableStateOf("")

    fun onCpfChange(novoCpf: String) {

        cpf = novoCpf
            .filter { it.isDigit() }
            .take(11)

        cpfErro = false
        cpfMensagem = ""
    }

    var dataNascimento by mutableStateOf(
        TextFieldValue("")
    )
    var dataNascimentoErro by mutableStateOf(false)
    var dataNascimentoMensagem by mutableStateOf("")

    fun onDataNascimentoChange(novaData: TextFieldValue) {

        val numeros = novaData.text
            .filter { it.isDigit() }
            .take(8)

        val formatado = when {

            numeros.length <= 2 ->
                numeros

            numeros.length <= 4 ->
                "${numeros.substring(0, 2)}/" +
                        numeros.substring(2)

            else ->
                "${numeros.substring(0, 2)}/" +
                        "${numeros.substring(2, 4)}/" +
                        numeros.substring(4)
        }

        dataNascimento = TextFieldValue(
            text = formatado,

            selection = TextRange(formatado.length)
        )

        dataNascimentoErro = false
        dataNascimentoMensagem = ""
    }

    fun validarData(data: String): Boolean {

        if (data.length != 10) return false

        val partes = data.split("/")

        if (partes.size != 3) return false

        val dia = partes[0].toIntOrNull() ?: return false
        val mes = partes[1].toIntOrNull() ?: return false
        val ano = partes[2].toIntOrNull() ?: return false

        if (dia !in 1..31) return false
        if (mes !in 1..12) return false
        if (ano !in 1900..2026) return false

        return true
    }

    var confirmarSenha by mutableStateOf("")
    var confirmarSenhaErro by mutableStateOf(false)
    var confirmarSenhaMensagem by mutableStateOf("")

    fun onConfirmarSenhaChange(novaSenha: String) {
        confirmarSenha = novaSenha
        confirmarSenhaErro = false
        confirmarSenhaMensagem = ""
    }

    fun validarDados(
        email: String,
        senha: String,
        nome: String,
        cpf: String,
        data: String
    ): Boolean {
        val emailValido = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        val senhaRegex = "^(?=.*[A-Z])(?=.*[@#\$%^&+=!]).{8,}$".toRegex()
        val senhaValida = senhaRegex.matches(senha)

        val nomeRegex = "^[A-ZÀ-Ý][a-zà-ÿ]+(\\s[A-ZÀ-Ý][a-zà-ÿ]+)+$".toRegex()
        val nomeValido = nome.length <= 100 && nomeRegex.matches(nome)

        val cpfValido = cpf.length == 11

        return emailValido && senhaValida && nomeValido && cpfValido && validarData(data)
    }


    // Lógica de autenticação
    fun tentarCadastrar(onSucesso: () -> Unit) {

        val isEmailOk = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        val senhaRegex = "^(?=.*[A-Z])(?=.*[@#\$%^&+=!]).{8,}$".toRegex()
        val isSenhaOk = senhaRegex.matches(senha)

        val nomeRegex = "^[A-ZÀ-Ý][a-zà-ÿ]+(\\s[A-ZÀ-Ý][a-zà-ÿ]+)+$".toRegex()
        val isNomeOk = nome.length <= 100 && nomeRegex.matches(nome)

        val isCpfOk = cpf.length == 11

        val isDataOk = validarData(dataNascimento.text)

        val isConfirmarSenhaOk = confirmarSenha == senha

        val dadosValidos = validarDados(
            email,
            senha,
            nome,
            cpf,
            dataNascimento.text
        ) && isConfirmarSenhaOk

        if (dadosValidos){
            onSucesso()
        } else {
            emailErro = !isEmailOk
            emailMensagem = if (!isEmailOk) "E-mail inválido" else ""

            senhaErro = !isSenhaOk
            senhaMensagem = if (!isSenhaOk) "Mínimo 8 caracteres e 1 maiúscula e 1 carctere especial" else ""

            nomeErro = !isNomeOk
            nomeMensagem = if (!isNomeOk) "Os nomes devem começar com letra maiúscula" else ""

            cpfErro = !isCpfOk
            cpfMensagem = if (!isCpfOk) "CPF deve conter apenas 11 números"  else ""

            dataNascimentoErro = !isDataOk
            dataNascimentoMensagem = if (!isDataOk) "Data inválida" else ""

            confirmarSenhaErro = !isConfirmarSenhaOk
            confirmarSenhaMensagem = if (!isConfirmarSenhaOk) "As senhas não coincidem"  else ""
        }
    }
}