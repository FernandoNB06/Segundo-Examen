package com.example.helloandroidstudio.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import org.koin.androidx.compose.koinViewModel

@Composable
fun GithubScreen(
    modifier: Modifier = Modifier
) {
    // Inyectamos el ViewModel con Koin
    val vm: GithubViewModel = koinViewModel()
    val state = vm.state.collectAsState().value

    var nickname by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ingresa el GitHub user")

        OutlinedTextField(
            value = nickname,
            onValueChange = { nickname = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedButton(onClick = { vm.searchUser(nickname) }) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Evaluamos el estado
        when (state) {
            is GithubViewModel.GithubUiState.Initial -> {
                Text("Esperando búsqueda...")
            }
            is GithubViewModel.GithubUiState.Loading -> {
                Text("Cargando...")
            }
            is GithubViewModel.GithubUiState.Success -> {
                val user = state.user
                Text(text = "Usuario: ${user.nickname}")
                Image(
                    painter = rememberAsyncImagePainter(user.pathURL),
                    contentDescription = "Avatar",
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Crop
                )
            }
            is GithubViewModel.GithubUiState.Error -> {
                Text("Error: ${state.message}")
            }
        }
    }
}
