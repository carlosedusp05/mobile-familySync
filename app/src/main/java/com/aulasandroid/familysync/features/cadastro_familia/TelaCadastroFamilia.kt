package com.aulasandroid.familysync.features.cadastro_familia

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.familysync.components.CremeButton
import com.aulasandroid.familysync.components.Family
import com.aulasandroid.familysync.components.OrangeButton
import com.aulasandroid.familysync.components.Outilined
import com.aulasandroid.familysync.components.OutlinedMenorDp
import com.aulasandroid.familysync.components.OutlinedPopUp
import com.aulasandroid.familysync.components.RowBack
import com.aulasandroid.familysync.features.cadastro_familia.model.TelaCadastroFamiliaViewModel
import com.aulasandroid.familysync.features.cadastro_familia.ui.CEPVisualTransformation
import com.aulasandroid.familysync.features.cadastro_familia.ui.TelefoneVisualTransformation
import com.aulasandroid.familysync.ui.theme.branco
import com.aulasandroid.familysync.ui.theme.vermelhoEscuro

@Composable
fun TelaCadastroFamilia(
    navController: NavController,
    viewModel: TelaCadastroFamiliaViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    ) {

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.updateImageUri(it) }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(branco)
    ) {

        RowBack(navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.95f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Family(
                    110.dp,
                    imageUri = viewModel.selectedImageUri,
                    onClick = {
                        galleryLauncher.launch("image/*")
                    }
                )

                if (viewModel.erroGeral.isNotEmpty()) {
                    Text(
                        text = viewModel.erroGeral,
                        textAlign = TextAlign.Center,
                        fontSize = 11.sp,
                        color = vermelhoEscuro,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(520.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedMenorDp (
                        placeHolder = "Nome da família",
                        width = 383.dp,
                        height = 52.dp,
                        viewModel.nomeFamilia,
                        {viewModel.onNomeFamiliaChange(it)}
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedMenorDp(
                        placeHolder = "Membros(emails separados por espaço)",
                        width = 383.dp,
                        height = 52.dp,
                        viewModel.membros,
                        {viewModel.onMembrosChange(it)}
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedMenorDp(
                        placeHolder = "Tel(Residencial)",
                        width = 243.dp,
                        height = 52.dp,
                        viewModel.telefone,
                        {viewModel.onTelefoneChange(it)},
                        KeyboardType.Number,
                        TelefoneVisualTransformation()
                    )

                    OutlinedMenorDp(
                        placeHolder = "CEP",
                        width = 133.dp,
                        height = 52.dp,
                        viewModel.cep,
                        {viewModel.onCepChange(it)},
                        KeyboardType.Number,
                        CEPVisualTransformation()
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedMenorDp(
                        placeHolder = "Cidade",
                        width = 283.dp,
                        height = 52.dp,
                        viewModel.cidade,
                        {viewModel.onCidadeChange(it)}
                    )

                    OutlinedMenorDp(
                        placeHolder = "UF",
                        width = 93.dp,
                        height = 52.dp,
                        viewModel.uf,
                        {viewModel.onUfChange(it)}
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedMenorDp(
                        placeHolder = "Bairro",
                        width = 383.dp,
                        height = 52.dp,
                        viewModel.bairro,
                        {viewModel.onBairroChange(it)}
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedMenorDp(
                        placeHolder = "Logradouro",
                        width = 383.dp,
                        height = 52.dp,
                        viewModel.logradouro,
                        {viewModel.onLogradouroChange(it)}
                    )
                }

                Row(
                    modifier = Modifier
                        .width(383.dp)
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedMenorDp(
                        placeHolder = "Numero",
                        width = 133.dp,
                        height = 52.dp,
                        viewModel.numero,
                        {viewModel.onNumeroChange(it)}
                    )

                    OutlinedMenorDp(
                        placeHolder = "Complemento(Opcional)",
                        width = 243.dp,
                        height = 52.dp,
                        viewModel.complemento,
                        {viewModel.onComplementoChange(it)}
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
                        abaAtiva = "cadastro_familia"
                    )

                    OrangeButton(
                        modifier = Modifier,
                        text = "Confirmar",
                        width = 150.dp,
                        height = 55.dp,
                        fontSize = 21,
                        navController,
                        abaAtiva = "cadastro_familia",
                        {
                            viewModel.tentarCadastrar {
                                navController.navigate("home")
                            }
                        }

                    )
                }
            }
        }
    }
}