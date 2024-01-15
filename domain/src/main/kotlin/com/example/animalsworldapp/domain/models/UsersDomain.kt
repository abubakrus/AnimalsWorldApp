package com.example.animalsworldapp.domain.models

data class UsersDomain(
    val about: String,
    val avatar: String,
    val contactWithMe: String,
    val createdAt: String,
    val lastName: String,
    val location: String,
    val name: String,
    val nickName: String,
    val id: String,
    val updatedAt: String
) {
    companion object {
        val unknown = UsersDomain(
            about = String(),
            avatar = String(),
            contactWithMe = String(),
            createdAt = String(),
            lastName = String(),
            location = String(),
            name = "unknown",
            nickName = String(),
            id = String(),
            updatedAt = String()
        )
    }
}
