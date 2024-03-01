package com.example.animalsworldapp.presentation.models

import androidx.compose.runtime.Stable
import com.example.animalsworldapp.domain.models.ForestDomain
import javax.annotation.concurrent.Immutable

@Stable
data class Forest(
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
    fun isUnknown() = this == Forest.unknown

    fun isNotUnknown() = this != Forest.unknown

    companion object {
        val unknown = Forest(
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

fun ForestDomain.toForest() = this.run {
    if (this == ForestDomain.unknown) return@run Forest.unknown
    Forest(
        about = about,
        backgroundImage = backgroundImage,
        createdAt = createdAt,
        image = image,
        interestingFact = interestingFact,
        location = location,
        name = name,
        id = id,
        updatedAt = updatedAt
    )
}

