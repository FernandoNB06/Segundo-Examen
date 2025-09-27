package com.example.helloandroidstudio.domain.repository

import com.example.helloandroidstudio.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getAllMovies(): Flow<List<MovieEntity>>
    suspend fun insertMovies(movies: List<MovieEntity>)
    suspend fun updateLike(movieId: Int, isLiked: Boolean)
}
