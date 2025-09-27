package com.example.helloandroidstudio.domain.model

import org.junit.Assert.*
import org.junit.Test

class PhoneTest {

    @Test
    fun `valid phone should be created`() {
        val phone = Phone("123456789")
        assertEquals("123456789", phone.toString())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `phone with letters should throw exception`() {
        Phone("12AB5678")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `too short phone should throw exception`() {
        Phone("123") // menos de 8 dígitos
    }

    @Test(expected = IllegalArgumentException::class)
    fun `too long phone should throw exception`() {
        Phone("1234567890123456") // más de 15 dígitos
    }
}
