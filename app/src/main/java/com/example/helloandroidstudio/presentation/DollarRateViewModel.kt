package com.example.helloandroidstudio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloandroidstudio.domain.repository.DollarRateRepository
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DollarRateViewModel(
    private val repository: DollarRateRepository
) : ViewModel() {

    // Estado con la lista de tasas
    private val _rates = MutableStateFlow<List<DollarRateEntity>>(emptyList())
    val rates: StateFlow<List<DollarRateEntity>> = _rates

    init {
        // cargar automáticamente al iniciar
        observeRates()
    }

    fun addRate(rate: DollarRateEntity) {
        viewModelScope.launch {
            repository.insertRate(rate)
        }
    }

    private fun observeRates() {
        viewModelScope.launch {
            repository.getAllRates().collectLatest { ratesList ->
                _rates.value = ratesList
            }
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}
