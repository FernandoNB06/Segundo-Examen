package com.example.helloandroidstudio.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dollar_rates")
data class DollarRateEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val officialBuy: Double,
    val officialSell: Double,
    val parallelBuy: Double,
    val parallelSell: Double,
    val date: String // fecha de actualización
)
