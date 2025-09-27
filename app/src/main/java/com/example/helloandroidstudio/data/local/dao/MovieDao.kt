package com.example.helloandroidstudio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.helloandroidstudio.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movies ORDER BY is_liked DESC")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("UPDATE movies SET is_liked = :isLiked WHERE id = :movieId")
    suspend fun updateLike(movieId: Int, isLiked: Boolean)
}

