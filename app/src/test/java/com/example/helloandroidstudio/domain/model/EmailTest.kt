package com.example.helloandroidstudio.domain.model

import org.junit.Assert.*
import org.junit.Test

class EmailTest {

    @Test
    fun `valid email should be created`() {
        val email = Email("test@example.com")
        assertEquals("test@example.com", email.toString())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `invalid email should throw exception`() {
        Email("invalid-email")
    }
}
