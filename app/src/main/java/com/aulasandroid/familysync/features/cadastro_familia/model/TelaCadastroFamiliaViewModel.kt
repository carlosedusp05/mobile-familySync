package com.aulasandroid.familysync.features.cadastro_familia.model

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import android.util.Patterns
import kotlin.text.take

class TelaCadastroFamiliaViewModel : ViewModel() {

    // ─── Mensagem de erro global ───────────────────────────────────────────────
    var erroGeral by mutableStateOf("")
        private set

    // ─── Nome da Família ───────────────────────────────────────────────────────
    var nomeFamilia by mutableStateOf("")
        private set

    fun onNomeFamiliaChange(novo: String) {
        // Apenas letras (incluindo acentuadas) e espaços, máximo 255
        nomeFamilia = novo
            .filter { it.isLetter() || it == ' ' }
            .take(255)
        erroGeral = ""
    }

    // ─── Membros (e-mails separados por espaço) ────────────────────────────────
    var membros by mutableStateOf("")
        private set

    fun onMembrosChange(novo: String) {
        membros = novo
        erroGeral = ""
    }

    // ─── Telefone ──────────────────────────────────────────────────────────────
    var telefone by mutableStateOf("")
        private set

    fun onTelefoneChange(novo: String) {
        telefone = novo
            .filter { it.isDigit() }
            .take(10)

        erroGeral = ""
    }

    // ─── CEP (máscara 00000-000) ───────────────────────────────────────────────
    var cep by mutableStateOf("")
        private set

    fun onCepChange(novo: String) {
        cep = novo
            .filter { it.isDigit() }
            .take(8)
        erroGeral = ""
    }

    // ─── UF ───────────────────────────────────────────────────────────────────────
    var uf by mutableStateOf("")
        private set

    fun onUfChange(novo: String) {
        uf = novo
            .filter { it.isLetter() }
            .take(2)
            .uppercase()
        erroGeral = ""
    }

    // ─── Cidade ────────────────────────────────────────────────────────────────
    var cidade by mutableStateOf("")
        private set

    fun onCidadeChange(novo: String) {
        cidade = novo.take(100)
        erroGeral = ""
    }

    // ─── Bairro ────────────────────────────────────────────────────────────────
    var bairro by mutableStateOf("")
        private set

    fun onBairroChange(novo: String) {
        bairro = novo.take(100)
        erroGeral = ""
    }

    // ─── Logradouro ────────────────────────────────────────────────────────────
    var logradouro by mutableStateOf("")
        private set

    fun onLogradouroChange(novo: String) {
        logradouro = novo.take(255)
        erroGeral = ""
    }

    // ─── Número ────────────────────────────────────────────────────────────────
    var numero by mutableStateOf("")
        private set

    fun onNumeroChange(novo: String) {
        numero = novo
            .filter { it.isLetterOrDigit() }   // sem especiais
            .take(10)
        erroGeral = ""
    }

    // ─── Complemento (opcional) ────────────────────────────────────────────────
    var complemento by mutableStateOf("")
        private set

    fun onComplementoChange(novo: String) {
        complemento = novo.take(100)
        erroGeral = ""
    }

    // ─── Validação ─────────────────────────────────────────────────────────────

    private fun validarNomeFamilia(): Boolean {
        val regex = "^[\\p{L} ]{1,255}$".toRegex()
        return regex.matches(nomeFamilia)
    }

    private fun validarMembros(): Boolean {
        if (membros.isBlank()) return false
        return membros
            .trim()
            .split("\\s+".toRegex())
            .all { Patterns.EMAIL_ADDRESS.matcher(it).matches() }
    }

    private fun validarTelefone(): Boolean =
        telefone.length == 10

    private fun validarCep(): Boolean =
        cep.length == 8

    private fun validarCidade(): Boolean =
        cidade.isNotBlank() && cidade.length <= 100

    private fun validarBairro(): Boolean =
        bairro.isNotBlank() && bairro.length <= 100

    private fun validarLogradouro(): Boolean =
        logradouro.isNotBlank() && logradouro.length <= 255

    private fun validarNumero(): Boolean =
        numero.isNotBlank() && numero.length <= 10

    private fun validarUf(): Boolean =
        uf.length == 2

    // Complemento é opcional — só valida o tamanho se preenchido
    private fun validarComplemento(): Boolean =
        complemento.length <= 100

    // ─── Tentativa de cadastro ─────────────────────────────────────────────────
    fun tentarCadastrar(onSucesso: () -> Unit) {

        val checks = listOf(
            validarNomeFamilia()  to "Nome da família inválido (somente letras, máx. 255 caracteres)",
            validarMembros()      to "Membros inválidos (informe e-mails válidos separados por espaço)",
            validarTelefone()     to "Telefone inválido (entre 8 e 20 dígitos)",
            validarCep()          to "CEP inválido (formato 00000-000)",
            validarUf()           to "UF inválida (2 letras maiúsculas, ex: SP)",
            validarCidade()       to "Cidade inválida (máx. 100 caracteres)",
            validarBairro()       to "Bairro inválido (máx. 100 caracteres)",
            validarLogradouro()   to "Logradouro inválido (máx. 255 caracteres)",
            validarNumero()       to "Número inválido (máx. 10 caracteres, sem especiais)",
            validarComplemento()  to "Complemento inválido (máx. 100 caracteres)"
        )

        val primeiroErro = checks.firstOrNull { (valido, _) -> !valido }

        if (primeiroErro == null) {
            erroGeral = ""
            onSucesso()
        } else {
            erroGeral = primeiroErro.second
        }
    }

    var selectedImageUri by mutableStateOf<Uri?>(null)
        private set

    fun updateImageUri(uri: Uri) {
        selectedImageUri = uri
    }
}