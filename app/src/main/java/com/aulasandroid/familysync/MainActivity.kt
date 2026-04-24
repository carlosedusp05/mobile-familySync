package com.aulasandroid.familysync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.aulasandroid.familysync.screens.cadastro_familia.TelaCadastroFamilia
import com.aulasandroid.familysync.screens.cadastro_usuario.TelaCadastroUsuario
import com.aulasandroid.familysync.screens.home.TelaHome
import com.aulasandroid.familysync.screens.home_sem_familia.TelaHomeSemFamilia
import com.aulasandroid.familysync.screens.notifiacao.TelaNotificacao
import com.aulasandroid.familysync.screens.perfil.TelaPerfil
import com.aulasandroid.familysync.ui.theme.FamilySyncTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FamilySyncTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaNotificacao(modifier = Modifier .padding(innerPadding))
                }
            }
        }
    }
}
