package com.example.helloandroidstudio.domain.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("login")
    val nickname: String,

    @SerializedName("avatar_url")
    val pathURL: String
)
