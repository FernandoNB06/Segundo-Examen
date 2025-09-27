package com.example.helloandroidstudio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DollarRateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDollarRate(rate: DollarRateEntity)

    @Query("SELECT * FROM dollar_rates ORDER BY date DESC LIMIT 1")
    fun getLatestDollarRate(): Flow<DollarRateEntity?>

    @Query("SELECT * FROM dollar_rates ORDER BY date DESC")
    fun getAllDollarRates(): Flow<List<DollarRateEntity>>
}
