package com.example.animalsworldapp.domain.models

data class FloraDomain (
    val id: String,
    val name: String,
    val backgroundImage: String,
    val image: String,
    val interestingFact: String,
    val aboutFlora: String,
    val location: String,

    ){
    companion object{
        val unknown = FloraDomain(
            id = String(),
            name = String(),
            backgroundImage = String(),
            image = String(),
            interestingFact = String(),
            aboutFlora = String(),
        location=String()

        )
    }
}