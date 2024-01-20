package com.example.animalsworldapp.presentation.models

import com.example.animalsworldapp.domain.models.FaunaDomain

data class Fauna(
    val objectId: String,
    val classes: String?,
    val name: String,
    val backgroundImage: String,
    val image: String,
    val interestingFact: String?,
    val aboutFauna: String,
    val location: String,
    val createdAt: String,
    val locationImage: String?,
    val updatedAt: String,
    val voice: String?,
) {
    fun isUnknown() = this == unknown

    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = Fauna(
            objectId = String(),
            classes = null,
            name = String(),
            backgroundImage = String(),
            image = String(),
            interestingFact = null,
            aboutFauna = String(),
            location = String(),
            createdAt = String(),
            locationImage = null,
            updatedAt = String(),
            voice = null
        )
    }
}

fun FaunaDomain.toFauna() = this.run {
    if (this == FaunaDomain.unknown) return@run Fauna.unknown
    Fauna(
        objectId = objectId,
        classes = classes,
        name = name,
        backgroundImage = backgroundImage,
        image = image,
        interestingFact = interestingFact,
        aboutFauna = aboutFauna,
        location = location,
        createdAt = createdAt,
        locationImage = locationImage,
        updatedAt = updatedAt,
        voice = voice
    )
}