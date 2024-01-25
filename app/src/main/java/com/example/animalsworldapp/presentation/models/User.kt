package com.example.animalsworldapp.presentation.models

import com.example.animalsworldapp.domain.models.UsersDomain

data class User(
    val about: String,
    val avatar: String,
    val contactWithMe: String,
    val createdAt: String,
    val lastName: String,
    val location: String,
    val name: String,
    val nickName: String,
    val id: String,
    val updatedAt: String,
    val email: String,
    val password: String,

    ) {
    fun isUnknown() = this == User.unknown

    fun isNotUnknown() = this != User.unknown

    companion object {
        val unknown = User(
            about = String(),
            avatar = String(),
            contactWithMe = String(),
            createdAt = String(),
            lastName = String(),
            location = String(),
            name = String(),
            nickName = String(),
            id = String(),
            updatedAt = String(),
            email = String(),
            password = String()
        )
    }
}


fun UsersDomain.toUser() = this.run {
    if (this == UsersDomain.unknown) return@run User.unknown
    User(
        about = about,
        avatar = avatar,
        contactWithMe = contactWithMe,
        createdAt = createdAt,
        lastName = lastName,
        location = location,
        name = name,
        nickName = nickName,
        id = id,
        updatedAt = updatedAt,
        email = email,
        password = password
    )
}

