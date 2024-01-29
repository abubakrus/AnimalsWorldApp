package com.example.animalsworldapp.domain.models

data class MountainDomain (
    val id: String,
    val name: String,
    val backgroundImage: String,
    val image: String,
    val interestingFact: String,
    val about: String,
    val location: String,
){
    companion object{
        val unknown = MountainDomain(
            id = String(),
            name = String(),
            backgroundImage = String(),
            image = String(),
            interestingFact = String(),
            about = String(),
            location = String()
        )
    }
}