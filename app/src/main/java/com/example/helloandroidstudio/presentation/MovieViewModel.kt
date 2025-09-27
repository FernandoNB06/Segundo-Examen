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

    private val _movies = MutableStateFlow<List<MovieEntity>>(emptyList())
    val movies: StateFlow<List<MovieEntity>> = _movies.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            repository.getAllMovies()
                .collect { movieList ->
                    _movies.value = movieList.sortedByDescending { it.isLiked }
                }
        }
    }

    fun insertMovie(movie: MovieEntity) {
        viewModelScope.launch {
            repository.insertMovies(listOf(movie)) // ajustado
        }
    }

    fun toggleLike(movie: MovieEntity) {
        viewModelScope.launch {
            val updated = movie.copy(isLiked = !movie.isLiked)
            repository.insertMovies(listOf(updated)) // REPLACE sobrescribe
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll() // ⚠️ este método hay que añadirlo en MovieRepository e Impl
        }
    }
}
