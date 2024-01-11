package com.example.animalsworldapp.presentation.models

import com.example.animalsworldapp.domain.models.FloraDomain

data class Flora(
    val id: String,
    val name: String,
    val backgroundImage: String,
    val image: String,
    val interestingFact: String,
    val aboutFlora: String,
) {

    fun isUnknown() = this == unknown

    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = Flora(
            id = String(),
            name = String(),
            backgroundImage = String(),
            image = String(),
            interestingFact = String(),
            aboutFlora = String()
        )
    }
}


fun FloraDomain.toMountain() = this.run {
    if (this == FloraDomain.unknown) return@run Flora.unknown
    Flora(
        id = id,
        name = name,
        backgroundImage = backgroundImage,
        image = image,
        interestingFact = interestingFact,
        aboutFlora = aboutFlora
    )
}