package com.example.helloandroidstudio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloandroidstudio.data.local.entity.MovieEntity
import com.example.helloandroidstudio.domain.repository.MovieRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    // Estado de las películas (Flow)
    private val _movies = MutableStateFlow<List<MovieEntity>>(emptyList())
    val movies: StateFlow<List<MovieEntity>> = _movies.asStateFlow()

    init {
        loadMovies()
    }

    // Cargar películas desde Room
    private fun loadMovies() {
        viewModelScope.launch {
            repository.getAllMovies()
                .collect { movieList ->
                    // Ordenamos: primero las con like
                    _movies.value = movieList.sortedByDescending { it.like }
                }
        }
    }

    // Insertar o actualizar película
    fun insertMovie(movie: MovieEntity) {
        viewModelScope.launch {
            repository.insertMovie(movie)
        }
    }

    // Cambiar el estado de like
    fun toggleLike(movie: MovieEntity) {
        viewModelScope.launch {
            val updated = movie.copy(like = !movie.like)
            repository.insertMovie(updated) // REPLACE sobrescribe
        }
    }

    // Borrar todas las películas
    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}
