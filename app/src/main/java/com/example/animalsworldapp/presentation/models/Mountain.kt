package com.example.animalsworldapp.presentation.models

import com.example.animalsworldapp.domain.models.MountainDomain

data class Mountain(
    val id: String,
    val name: String,
    val backgroundImage: String,
    val image: String,
    val interestingFact: String,
    val about: String,
){

    fun isUnknown() = this == unknown

    fun isNotUnknown() = this != unknown

    companion object {
        val unknown = Mountain(
            id = String(),
            name = String(),
            backgroundImage = String(),
            image = String(),
            interestingFact = String(),
            about = String()
        )
    }
}


fun MountainDomain.toMountain() = this.run {
    if (this == MountainDomain.unknown) return@run Mountain.unknown
    Mountain(
        id = id,
        name = name,
        backgroundImage = backgroundImage,
        image = image,
        interestingFact = interestingFact,
        about = about
    )
}
