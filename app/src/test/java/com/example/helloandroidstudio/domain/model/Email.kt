package com.example.helloandroidstudio.domain.model

import org.junit.Assert.*
import org.junit.Test

class EmailTest {

    @Test
    fun `crear Email valido`() {
        val email = Email("test@example.com")
        assertEquals("test@example.com", email.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `crear Email sin arroba lanza excepcion`() {
        Email("correo_invalido.com")
    }
}
