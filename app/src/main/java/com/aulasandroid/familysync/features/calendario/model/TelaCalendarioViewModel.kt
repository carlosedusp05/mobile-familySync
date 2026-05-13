package com.aulasandroid.familysync.features.calendario.model

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModel
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
class TelaCalendarioViewModel : ViewModel() {

    val datePickerState = DatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
        locale = Locale.getDefault(),
        initialDisplayedMonthMillis = System.currentTimeMillis(),
        yearRange = IntRange(2024, 2100),
        initialDisplayMode = DisplayMode.Picker
    )

    fun getDataSelecionada(): Long? {
        return datePickerState.selectedDateMillis
    }
}