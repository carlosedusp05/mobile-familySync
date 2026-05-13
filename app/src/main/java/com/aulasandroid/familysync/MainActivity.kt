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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aulasandroid.familysync.features.adicionar_despesas.TelaAdicionarDespesas
import com.aulasandroid.familysync.features.alterar_endereco.TelaAlterarEndereco
import com.aulasandroid.familysync.features.cadastro_familia.TelaCadastroFamilia
import com.aulasandroid.familysync.features.cadastro_usuario.TelaCadastroUsuario
import com.aulasandroid.familysync.features.calendario.TelaCalendario
import com.aulasandroid.familysync.features.criar_lista.TelaCriarLista
import com.aulasandroid.familysync.features.despesas.TelaDespesas
import com.aulasandroid.familysync.features.editar_despesas.TelaEditarDespesas
import com.aulasandroid.familysync.features.editar_lista.TelaEditarLista
import com.aulasandroid.familysync.features.esqueceu_senha.TelaEsqueceuSenha
import com.aulasandroid.familysync.features.eventos.TelaEventos
import com.aulasandroid.familysync.features.gerenciador_familiar.TelaGerenciarFamilia
import com.aulasandroid.familysync.features.home.TelaHome
import com.aulasandroid.familysync.features.home_sem_familia.TelaHomeSemFamilia
import com.aulasandroid.familysync.features.informacoes_familiar.TelaInformacoesFamiliar
import com.aulasandroid.familysync.features.lista.TelaLista
import com.aulasandroid.familysync.features.listas.TelaListas
import com.aulasandroid.familysync.features.login.TelaLogin
import com.aulasandroid.familysync.features.notificacao.TelaNotificacao
import com.aulasandroid.familysync.features.perfil.TelaPerfil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FamilySyncTheme {

                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        // Telas de Acesso e Cadastro
                        composable(route = "login") { TelaLogin(navController) }
                        composable(route = "cadastro_usuario") { TelaCadastroUsuario(navController) }
                        composable(route = "esqueceu_senha") { TelaEsqueceuSenha(navController) }

                        // Telas Principais (Home)
                        composable(route = "home") { TelaHome(navController) }
                        composable(route = "home_sem_familia") { TelaHomeSemFamilia(navController) }

                        // Gerenciamento de Família
                        composable(route = "cadastro_familia") { TelaCadastroFamilia(navController) }
                        composable(route = "gerenciador_familiar") { TelaGerenciarFamilia(navController) }
                        composable(route = "informacoes_familiar") { TelaInformacoesFamiliar(navController) }
                        composable(route = "alterar_endereco") { TelaAlterarEndereco(navController) }


                        // Despesas
                        composable(route = "despesas") { TelaDespesas(navController) }
                        composable(route = "adicionar_despesas") { TelaAdicionarDespesas(navController) }
                        composable(route = "editar_despesas") { TelaEditarDespesas(navController) }

                        // Lista
                        composable(route = "listas") { TelaListas(navController) }
                        composable(route = "lista") { TelaLista(navController) }
                        composable(route = "editar-lista") { TelaEditarLista(navController) }
                        composable(route = "criar-lista") { TelaCriarLista(navController) }

                        // Outros Recursos
                        composable(route = "calendario") { TelaCalendario(navController) }
                        composable(route = "eventos") { TelaEventos(navController) }
                        composable(route = "notificacao") { TelaNotificacao(navController) }
                        composable(route = "perfil") { TelaPerfil(navController) }
                    }
                }
            }
        }
    }
}
