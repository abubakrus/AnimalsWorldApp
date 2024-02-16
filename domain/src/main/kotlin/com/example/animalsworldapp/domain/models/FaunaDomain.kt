package com.example.animalsworldapp.domain.models

data class FaunaDomain(
    val objectId: String,
    val classes: String,
    val name: String,
    val backgroundImage: String,
    val image: String,
    val videoUri: String,
    val interestingFact: String?,
    val aboutFauna: String,
    val location: String,
    val createdAt: String,
    val locationImage: String,
    val updatedAt: String,
    val voice: String?
) {
    companion object {
        val unknown = FaunaDomain(
            objectId = String(),
            classes = String(),
            name = String(),
            backgroundImage = String(),
            image = String(),
            interestingFact = null,
            aboutFauna = String(),
            location = String(),
            createdAt = String(),
            locationImage = String(),
            updatedAt = String(),
            voice = null,
            videoUri = String()
        )
    }
}