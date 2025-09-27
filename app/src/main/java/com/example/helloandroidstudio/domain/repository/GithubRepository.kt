package com.example.helloandroidstudio.domain.repository

import com.example.helloandroidstudio.domain.model.UserModel

interface GithubRepository {
     suspend fun findByNick(nickname: String): Result<UserModel>
}
