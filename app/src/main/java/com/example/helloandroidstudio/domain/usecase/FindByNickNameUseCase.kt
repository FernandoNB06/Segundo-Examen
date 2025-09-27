package com.example.helloandroidstudio.domain.usecase

import com.example.helloandroidstudio.domain.model.UserModel
import com.example.helloandroidstudio.domain.repository.GithubRepository

class FindByNickNameUseCase(
    private val repository: GithubRepository
) {
    suspend fun invoke(nickname: String): Result<UserModel> {
        if (nickname.isBlank()) {
            return Result.failure(Exception("El campo no puede estar vacío"))
        }
        return repository.findByNick(nickname)
    }
}
