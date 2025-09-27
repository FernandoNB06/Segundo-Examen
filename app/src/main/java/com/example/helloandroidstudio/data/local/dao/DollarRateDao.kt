package com.example.helloandroidstudio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity

@Dao
interface DollarRateDao {

    @Insert
    suspend fun insertRate(rate: DollarRateEntity)

    @Query("SELECT * FROM dollar_rates")
    suspend fun getAllRates(): List<DollarRateEntity>

    @Query("DELETE FROM dollar_rates")
    suspend fun deleteAll()
}
