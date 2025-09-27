package com.example.helloandroidstudio.domain.model

@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotBlank()) { "Name cannot be empty" }
    }

    override fun toString(): String = value
}
