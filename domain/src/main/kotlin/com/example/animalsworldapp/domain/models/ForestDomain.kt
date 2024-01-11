package com.example.animalsworldapp.domain.models

data class ForestDomain(
    val about: String,
    val backgroundImage: String,
    val createdAt: String,
    val image: String,
    val interestingFact: String,
    val location: String,
    val name: String,
    val id: String,
    val updatedAt: String
) {
    companion object {
        val unknown = ForestDomain(
            about = String(),
            backgroundImage = String(),
            createdAt = String(),
            image = String(),
            interestingFact = String(),
            location = String(),
            name = String(),
            id = String(),
            updatedAt = String()
        )
    }
}
