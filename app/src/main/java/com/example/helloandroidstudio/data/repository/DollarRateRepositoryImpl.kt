package com.example.helloandroidstudio.data.repository

import com.example.helloandroidstudio.data.local.dao.DollarRateDao
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import com.example.helloandroidstudio.domain.repository.DollarRateRepository
import kotlinx.coroutines.flow.Flow

class DollarRateRepositoryImpl(
    private val dao: DollarRateDao
) : DollarRateRepository {

    override fun getAllRates(): Flow<List<DollarRateEntity>> {
        return dao.getAllRates()
    }

    override suspend fun insertRate(rate: DollarRateEntity) {
        dao.insertRate(rate)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}
