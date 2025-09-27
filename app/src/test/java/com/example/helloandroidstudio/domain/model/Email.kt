package com.example.helloandroidstudio.domain.model

@JvmInline
value class Email(private val value: String) {
    init {
        require(value.contains("@")) { "Email must contain @" }
    }

    override fun toString(): String = value
}
