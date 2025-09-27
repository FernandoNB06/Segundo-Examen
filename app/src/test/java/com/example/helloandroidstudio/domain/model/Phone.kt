package com.example.helloandroidstudio.domain.model

@JvmInline
value class Phone(val value: String) {
    init {
        require(value.matches(Regex("^[0-9]{8,15}\$"))) {
            "Phone must have between 8 and 15 digits"
        }
    }

    override fun toString(): String = value
}
