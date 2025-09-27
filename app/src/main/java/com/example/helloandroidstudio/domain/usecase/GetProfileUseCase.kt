package com.example.helloandroidstudio.domain.usecase

import com.example.helloandroidstudio.domain.model.ProfileModel
import com.example.helloandroidstudio.domain.model.Email
import com.example.helloandroidstudio.domain.model.Name
import com.example.helloandroidstudio.domain.model.Phone

/**
 * Caso de uso para obtener el perfil del usuario.
 * Por ahora devolvemos un perfil "falso" (mock) solo para pruebas.
 */
class GetProfileUseCase {

    operator fun invoke(): ProfileModel {
        return ProfileModel(
            id = 1,
            name = Name("Fernando Nogales"),
            email = Email("fernando@example.com"),
            phone = Phone("+59170000000")
        )
    }
}
