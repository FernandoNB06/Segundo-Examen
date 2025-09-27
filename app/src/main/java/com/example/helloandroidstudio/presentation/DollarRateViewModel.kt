package com.example.helloandroidstudio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloandroidstudio.domain.repository.DollarRateRepository
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class   DollarRateViewModel(
    private val repository: DollarRateRepository
) : ViewModel() {

    // Estado con la lista de tasas
    private val _rates = MutableStateFlow<List<DollarRateEntity>>(emptyList())
    val rates: StateFlow<List<DollarRateEntity>> = _rates

    // Insertar nueva tasa
    fun insertRate(rate: DollarRateEntity) {
        viewModelScope.launch {
            repository.insertRate(rate)
            loadRates() // refrescar
        }
    }

    // Obtener todas las tasas
    fun loadRates() {
        viewModelScope.launch {
            _rates.value = repository.getAllRates()
        }
    }

    // Borrar todas las tasas
    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
            _rates.value = emptyList()
        }
    }
}
