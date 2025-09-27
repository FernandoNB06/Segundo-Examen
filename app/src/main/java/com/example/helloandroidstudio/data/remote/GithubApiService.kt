package com.example.helloandroidstudio.data.remote

import com.example.helloandroidstudio.domain.model.UserModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): UserModel
}
