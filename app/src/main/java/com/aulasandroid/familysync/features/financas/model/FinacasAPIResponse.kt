package com.aulasandroid.familysync.features.financas.model

data class ItemTelaFinanca(
    val id: Int,
    val titulo: String,
    val icone: String,
    val valor: String
)

//DIARIAS
data class FinancasDiariasResponse(
    val StatusCode: Int,
    val Response: FamiliaFinancasDiarias
)

data class FamiliaFinancasDiarias(
    val id_familia: Int,
    val nome: String,
    val financas: List<FinancaDiaria>
)

data class FinancaDiaria(
    val id_financas: Int,
    val descricao: String?,
    val tipo: String?,
    val valor: String?,
    val icone: String?
)

//SEMANAIS
data class FinancasSemanaisResponse(
    val StatusCode: Int,
    val Response: FamiliaFinancasSemanais
)

data class FamiliaFinancasSemanais(
    val id_familia: Int,
    val nome: String,
    val financas: List<FinancaSemanal>
)

data class FinancaSemanal(
    val id_familia: Int,
    val dia_semana: String?,
    val total: String?
)

//MENSAIS
data class FinancasMensaisResponse(
    val StatusCode: Int,
    val Response: FamiliaFinancasMensais
)

data class FamiliaFinancasMensais(
    val id_familia: Int,
    val nome: String,
    val financas: List<FinancaMensal>
)

data class FinancaMensal(
    val id_familia: Int,
    val semana_mes: String?,
    val mes: Int?,
    val ano: Int?,
    val total: String?
)

//ANUAIS
data class FinancasAnuaisResponse(
    val StatusCode: Int,
    val Response: FamiliaFinancasAnuais
)

data class FamiliaFinancasAnuais(
    val id_familia: Int,
    val nome: String,
    val financas: List<FinancaAnual>
)

data class FinancaAnual(
    val id_familia: Int,
    val mes: String?,
    val total: String?
)
