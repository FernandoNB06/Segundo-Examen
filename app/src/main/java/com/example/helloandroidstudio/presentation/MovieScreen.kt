package com.example.helloandroidstudio.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.helloandroidstudio.data.local.entity.MovieEntity
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    vm: MovieViewModel = koinViewModel()
) {
    val movies by vm.movies.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Películas Populares")

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(movies) { movie ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = movie.title)

                    Button(
                        onClick = { vm.toggleLike(movie) },
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text(if (movie.like) "Quitar Like" else "Like")
                    }
                }
            }
        }
    }
}
