package com.example.helloandroidstudio.domain.model

import org.junit.Assert.*
import org.junit.Test

class NameTest {

    @Test
    fun `crear Name valido`() {
        val name = Name("Fernando")
        assertEquals("Fernando", name.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `crear Name vacio lanza excepcion`() {
        Name("")
    }
}
