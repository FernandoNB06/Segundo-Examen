package com.example.helloandroidstudio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloandroidstudio.domain.model.UserModel
import com.example.helloandroidstudio.domain.usecase.FindByNickNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GithubViewModel(
    private val findByNickNameUseCase: FindByNickNameUseCase
) : ViewModel() {

    // Definimos los posibles estados de la UI
    sealed class GithubUiState {
        object Initial : GithubUiState()
        object Loading : GithubUiState()
        data class Success(val user: UserModel) : GithubUiState()
        data class Error(val message: String) : GithubUiState()
    }

    // Estado actual
    private val _state = MutableStateFlow<GithubUiState>(GithubUiState.Initial)
    val state: StateFlow<GithubUiState> = _state

    fun searchUser(nickname: String) {
        viewModelScope.launch {
            _state.value = GithubUiState.Loading
            val result = findByNickNameUseCase.invoke(nickname)
            result.onSuccess { userModel ->
                _state.value = GithubUiState.Success(userModel)
            }.onFailure { error ->
                _state.value = GithubUiState.Error(error.message ?: "Error desconocido")
            }
        }
    }
}
