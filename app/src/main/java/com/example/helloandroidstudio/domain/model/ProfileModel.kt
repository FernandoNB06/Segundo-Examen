package com.example.helloandroidstudio.domain.model

// ---------- Value Objects ----------

// Nombre
@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotBlank()) { "El nombre no puede estar vacío" }
    }
    override fun toString() = value
}

// Email
@JvmInline
value class Email(val value: String) {
    init {
        require(value.isNotBlank()) { "El email no puede estar vacío" }
        require(android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            "Formato de email inválido"
        }
    }
    override fun toString() = value
}

// Teléfono
@JvmInline
value class Phone(val value: String) {
    init {
        require(value.matches(Regex("^\\+?[0-9]{7,15}$"))) {
            "Número de teléfono inválido"
        }
    }
    override fun toString() = value
}

// ---------- Profile Model ----------
data class ProfileModel(
    val id: Int,
    val name: Name,
    val email: Email,
    val phone: Phone
)
