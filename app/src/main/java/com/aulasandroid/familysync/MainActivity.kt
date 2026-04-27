package com.aulasandroid.familysync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.aulasandroid.familysync.screens.notifiacao.TelaNotificacao
import com.aulasandroid.familysync.ui.theme.FamilySyncTheme
import androidx.compose.ui.Modifier

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
