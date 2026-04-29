package com.aulasandroid.familysync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.aulasandroid.familysync.ui.theme.FamilySyncTheme
import androidx.compose.ui.Modifier
import com.aulasandroid.familysync.screens.adicionar_dispesas.TelaAdicionarDespesas
import com.aulasandroid.familysync.screens.alterar_endereco.TelaAlterarEndereco
import com.aulasandroid.familysync.screens.cadastro_familia.TelaCadastroFamilia
import com.aulasandroid.familysync.screens.calendario.TelaCalendario
import com.aulasandroid.familysync.screens.editar_despesas.TelaEditarDespesas
import com.aulasandroid.familysync.screens.gerenciador_familiar.TelaGerenciarFamilia
import com.aulasandroid.familysync.screens.informacoes_familiar.TelaInformacoesFamiliar
import com.aulasandroid.familysync.screens.login.TelaLoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FamilySyncTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaCalendario(modifier = Modifier .padding(innerPadding))
                }
            }
        }
    }
}
