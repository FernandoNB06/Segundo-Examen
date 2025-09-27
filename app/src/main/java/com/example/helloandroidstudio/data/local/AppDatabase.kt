package com.example.helloandroidstudio.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.helloandroidstudio.data.local.dao.DollarRateDao
import com.example.helloandroidstudio.data.local.entity.DollarRateEntity

@Database(
    entities = [DollarRateEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dollarRateDao(): DollarRateDao
}
