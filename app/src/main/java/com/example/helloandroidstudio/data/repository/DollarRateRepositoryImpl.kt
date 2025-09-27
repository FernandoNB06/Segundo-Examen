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
    suspend fun insertRate(rate: DollarRateEntity)

    @Query("SELECT * FROM dollar_rates ORDER BY id DESC")
    fun getAllRates(): Flow<List<DollarRateEntity>>   // 👈 Flow en vez de List

    @Query("DELETE FROM dollar_rates")
    suspend fun deleteAll()
}
