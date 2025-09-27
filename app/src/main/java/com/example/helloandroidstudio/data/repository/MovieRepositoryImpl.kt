package com.example.helloandroidstudio.data.repository

import com.example.helloandroidstudio.data.local.dao.MovieDao
import com.example.helloandroidstudio.data.local.entity.MovieEntity
import com.example.helloandroidstudio.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val dao: MovieDao
) : MovieRepository {

    override fun getAllMovies(): Flow<List<MovieEntity>> {
        return dao.getAllMovies()
    }

    override suspend fun insertMovies(movies: List<MovieEntity>) {
        movies.forEach { movie ->
            dao.insertMovie(movie)
        }
    }

    override suspend fun updateLike(movieId: Int, isLiked: Boolean) {
        dao.updateLike(movieId, isLiked)
    }
    override suspend fun deleteAll() {
        dao.deleteAll()
    }

}
