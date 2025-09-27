package com.example.helloandroidstudio.domain.model

import org.junit.Assert.*
import org.junit.Test

class PhoneTest {

    @Test
    fun `valid phone should be created`() {
        val phone = Phone("+59112345678")
        assertEquals("+59112345678", phone.toString())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `invalid phone should throw exception`() {
        Phone("12345678")
    }
}
