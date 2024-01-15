package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.models.UsersDomain


interface CurrentUserRepository {

    fun saveCurrentUser(user: UsersDomain)

    fun fetchCurrentUser(): UsersDomain

    fun clearCurrentUser()

}