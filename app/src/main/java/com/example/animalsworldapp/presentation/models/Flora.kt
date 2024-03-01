package com.example.animalsworldapp.presentation.models

import androidx.compose.runtime.Stable
import com.example.animalsworldapp.domain.models.FloraDomain
import javax.annotation.concurrent.Immutable


@Stable
data class Flora(
    val id: String,
    val name: String,
    val backgroundImage: String,
    val image: String,
    val interestingFact: String,
    val aboutFlora: String,
    val location: String,
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
            aboutFlora = String(),
            location = String()
        )
    }
}


fun FloraDomain.toFlora() = this.run {
    if (this == FloraDomain.unknown) return@run Flora.unknown
    Flora(
        id = id,
        name = name,
        backgroundImage = backgroundImage,
        image = image,
        interestingFact = interestingFact,
        aboutFlora = aboutFlora,
        location = location
    )
}