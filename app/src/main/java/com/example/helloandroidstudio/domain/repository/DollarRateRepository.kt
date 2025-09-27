package com.example.helloandroidstudio.domain.repository

import com.example.helloandroidstudio.data.local.entity.DollarRateEntity

interface DollarRateRepository {
    suspend fun insertRate(rate: DollarRateEntity)
    suspend fun getAllRates(): List<DollarRateEntity>
    suspend fun deleteAll()
}
