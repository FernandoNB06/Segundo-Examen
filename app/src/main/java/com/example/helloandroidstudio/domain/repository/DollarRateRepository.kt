package com.example.helloandroidstudio.domain.repository

import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import kotlinx.coroutines.flow.Flow

interface DollarRateRepository {
    suspend fun insertRate(rate: DollarRateEntity)
    fun getAllRates(): Flow<List<DollarRateEntity>>   // ← Flow, no suspend
    suspend fun deleteAll()
}
