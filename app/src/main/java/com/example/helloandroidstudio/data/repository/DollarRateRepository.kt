package com.example.helloandroidstudio.data.repository

import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import kotlinx.coroutines.flow.Flow

interface DollarRateRepository {
    suspend fun insertRate(rate: DollarRateEntity)
    fun getAllRates(): Flow<List<DollarRateEntity>>
    suspend fun deleteAll()
}
