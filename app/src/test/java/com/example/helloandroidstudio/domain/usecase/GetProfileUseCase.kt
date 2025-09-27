package com.example.helloandroidstudio.domain.usecase

import com.example.helloandroidstudio.domain.model.Email
import com.example.helloandroidstudio.domain.model.Name
import com.example.helloandroidstudio.domain.model.ProfileModel
import org.junit.Assert.*
import org.junit.Test

class GetProfileUseCaseTest {

    @Test
    fun `ejecutar usecase devuelve Profile valido`() {
        val useCase = GetProfileUseCase()
        val profile = useCase()

        assertTrue(profile is ProfileModel)
        assertTrue(profile.name is Name)
        assertTrue(profile.email is Email)
    }
}
