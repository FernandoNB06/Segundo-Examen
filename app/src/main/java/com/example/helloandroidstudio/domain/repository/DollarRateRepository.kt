package com.example.helloandroidstudio.domain.repository

import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import kotlinx.coroutines.flow.Flow

interface DollarRateRepository {
    fun getAllRates(): Flow<List<DollarRateEntity>>
    suspend fun insertRate(rate: DollarRateEntity)
    suspend fun deleteAll()
}
