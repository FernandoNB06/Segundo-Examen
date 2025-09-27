package com.example.helloandroidstudio.domain.model

import org.junit.Assert.*
import org.junit.Test

class NameTest {

    @Test
    fun `valid name should be created`() {
        val name = Name("Fernando")
        assertEquals("Fernando", name.toString())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `empty name should throw exception`() {
        Name("")
    }
}
