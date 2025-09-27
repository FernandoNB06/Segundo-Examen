package com.example.helloandroidstudio.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo


@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val posterPath: String?,
    val overview: String?,
    @ColumnInfo(name = "is_liked")  // 👈 nuevo nombre de columna
    val isLiked: Boolean = false
)


