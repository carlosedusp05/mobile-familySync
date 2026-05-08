package com.aulasandroid.familysync.features.cadastro_usuario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.components.OutilinedIcon
import com.aulasandroid.familysync.components.Profile
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.features.cadastro_usuario.model.CadastroUsuarioViewModel
import com.aulasandroid.familysync.features.login.model.LoginViewModel
import com.aulasandroid.familysync.ui.theme.branco

@Composable
fun TelaCadastroUsuario(
    navController: NavController,
    viewModel: CadastroUsuarioViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {
    Column(
        modifier = Modifier .fillMaxSize() .background(branco)
    ) {

        RowBack(navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.97f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Profile(110.dp)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(470.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Outilined(
                    modifier = Modifier,
                    placeHolder = "Nome",
                    width = 383.dp,
                    height = 75.dp,
                    viewModel.nome,
                    {viewModel.onNomeChange(it)},
                    isError = viewModel.nomeErro,
                    mensagemErro = viewModel.nomeMensagem
                )

                Outilined(
                    modifier = Modifier,
                    placeHolder = "Data Nascimento",
                    width = 383.dp,
                    height = 75.dp,
                    viewModel.dataNascimento,
                    {viewModel.onDataNascimentoChange(it)},
                    isError = viewModel.dataNascimentoErro,
                    mensagemErro = viewModel.dataNascimentoMensagem
                )

                Outilined(
                    modifier = Modifier,
                    placeHolder = "CPF (apenas números)",
                    width = 383.dp,
                    height = 75.dp,
                    viewModel.cpf,
                    {viewModel.onCpfChange(it)},
                    isError = viewModel.cpfErro,
                    mensagemErro = viewModel.cpfMensagem
                )

                Outilined(
                    modifier = Modifier,
                    placeHolder = "E-mail",
                    width = 383.dp,
                    height = 75.dp,
                    viewModel.email,
                    {viewModel.onEmailChange(it)},
                    isError = viewModel.emailErro,
                    mensagemErro = viewModel.emailMensagem
                )

                OutilinedIcon(
                    modifier = Modifier,
                    placeHolder = "senha",
                    width = 383.dp,
                    height = 75.dp,
                    viewModel.senha,
                    {viewModel.onSenhaChange(it)},
                    isError = viewModel.senhaErro,
                    mensagemErro = viewModel.senhaMensagem
                )

                OutilinedIcon(
                    modifier = Modifier,
                    placeHolder = "Confirmar Senha",
                    width = 383.dp,
                    height = 75.dp,
                    viewModel.confirmarSenha,
                    { viewModel.onConfirmarSenhaChange(it) },
                    isError = viewModel.confirmarSenhaErro,
                    mensagemErro = viewModel.confirmarSenhaMensagem
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CremeButton(
                    modifier = Modifier,
                    text = "Cancelar",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 22,
                    navController,
                    "cadastro_usuario"
                )

                OrangeButton(
                    modifier = Modifier,
                    text = "Confirmar",
                    width = 150.dp,
                    height = 55.dp,
                    fontSize = 21,
                    navController,
                    "cadastro_usuario",
                    onClick = {
                        viewModel.tentarCadastrar {
                            navController.navigate("login")
                        }
                    }
                )
            }
        }
    }
}