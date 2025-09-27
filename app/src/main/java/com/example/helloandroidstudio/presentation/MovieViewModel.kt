package com.example.helloandroidstudio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloandroidstudio.data.local.entity.MovieEntity
import com.example.helloandroidstudio.domain.repository.MovieRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    val movies = repository.getAllMovies()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun likeMovie(movieId: Int, isLiked: Boolean) {
        viewModelScope.launch {
            repository.updateLike(movieId, isLiked)
        }
    }

    fun addMovie(movie: MovieEntity) {
        viewModelScope.launch {
            repository.insertMovie(movie)
        }
    }
}
