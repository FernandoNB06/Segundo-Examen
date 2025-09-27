package com.example.helloandroidstudio.data.repository

import com.example.helloandroidstudio.data.remote.GithubApiService
import com.example.helloandroidstudio.domain.model.UserModel
import com.example.helloandroidstudio.domain.repository.GithubRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubRepositoryImpl : GithubRepository {

    private val api: GithubApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")  // base de GitHub
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApiService::class.java)
    }

    override suspend fun findByNick(nickname: String): Result<UserModel> {
        return try {
            val user = api.getUser(nickname)
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
