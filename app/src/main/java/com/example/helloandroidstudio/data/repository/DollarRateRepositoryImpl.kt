package com.example.helloandroidstudio.data.repository

import com.example.helloandroidstudio.data.local.dao.DollarRateDao
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity

class DollarRateRepositoryImpl(
    private val dao: DollarRateDao
) {
    suspend fun insertRate(rate: DollarRateEntity) {
        dao.insertRate(rate)
    }

    suspend fun getAllRates(): List<DollarRateEntity> {
        return dao.getAllRates()
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}
