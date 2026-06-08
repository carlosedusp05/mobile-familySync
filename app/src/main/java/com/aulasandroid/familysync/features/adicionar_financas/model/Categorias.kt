package com.aulasandroid.familysync.features.adicionar_financas.model

data class CategoriaFinanca(
    val icon: String,
    val label: String
)

val categorias = listOf(
    CategoriaFinanca("🛍️", "Compras"),
    CategoriaFinanca("💡", "Luz"),
    CategoriaFinanca("💧", "Água"),
    CategoriaFinanca("🏠", "Casa"),
    CategoriaFinanca("❤️", "Saúde"),
    CategoriaFinanca("📖", "Educação"),
    CategoriaFinanca("🍴", "Alimentação"),
    CategoriaFinanca("👥", "Família"),
    CategoriaFinanca("🚗", "Transporte"),
    CategoriaFinanca("🎮", "Lazer"),
    CategoriaFinanca("📱", "Assinaturas"),
    CategoriaFinanca("💰", "Outros")
)