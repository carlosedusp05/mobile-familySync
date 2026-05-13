package com.aulasandroid.familysync.features.lista.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aulasandroid.familysync.features.lista.ProdutoItem

class TelaListaViewModel : ViewModel() {
var listaProdutos by mutableStateOf(
        listOf(
            ProdutoItem(1, "farinha", 23.00, 4),
            ProdutoItem(2, "suco", 1.50, 9),
            ProdutoItem(3, "Arroz 10Kg", 73.00, 1),
            ProdutoItem(4, "farinha", 23.00, 4),
            ProdutoItem(5, "suco", 1.50, 9),
            ProdutoItem(6, "Arroz 10Kg", 73.00, 1),
            ProdutoItem(7, "farinha", 23.00, 4),
            ProdutoItem(8, "suco", 1.50, 9),
            ProdutoItem(9, "Arroz 10Kg", 73.00, 1)
        )
    )

fun selecionarTodos() {
    listaProdutos = listaProdutos.map { it.copy(isChecked = true) }
}


fun mudarCheckItem(id: Int, novoValor: Boolean) {
    listaProdutos = listaProdutos.map {
        if (it.id == id) it.copy(isChecked = novoValor) else it
    }
}
    }

