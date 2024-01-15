package com.example.animalsworldapp.di

import com.example.animalsworldapp.data.repositories.CurrentUserRepositoryImpl
import com.example.animalsworldapp.data.repositories.FaunaRepositoryImpl
import com.example.animalsworldapp.data.repositories.FloraRepositoryImpl
import com.example.animalsworldapp.data.repositories.ForestRepositoryImpl
import com.example.animalsworldapp.data.repositories.LoginRepositoryImpl
import com.example.animalsworldapp.data.repositories.MountainRepositoryImpl
import com.example.animalsworldapp.data.repositories.ShowedOnBoardingRepositoryImpl
import com.example.animalsworldapp.data.repositories.UsersRepositoryImpl
import com.example.animalsworldapp.domain.repositories.CurrentUserRepository
import com.example.animalsworldapp.domain.repositories.FaunaRepository
import com.example.animalsworldapp.domain.repositories.FloraRepository
import com.example.animalsworldapp.domain.repositories.ForestRepository
import com.example.animalsworldapp.domain.repositories.LoginRepository
import com.example.animalsworldapp.domain.repositories.MountainRepository
import com.example.animalsworldapp.domain.repositories.ShowedOnBoardingRepository
import com.example.animalsworldapp.domain.repositories.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsFaunaRepository(
        implementation: FaunaRepositoryImpl
    ): FaunaRepository

    @Binds
    fun bindsShowedOnBoardingRepository(
        implementation: ShowedOnBoardingRepositoryImpl
    ): ShowedOnBoardingRepository

    @Binds
    fun bindsFloraRepositoryImpl(
        implementation: FloraRepositoryImpl
    ): FloraRepository

    @Binds
    fun bindsMountainRepositoryImpl(
        implementation: MountainRepositoryImpl
    ): MountainRepository

    @Binds
    fun bindsUsersRepositoryImpl(
        implementation: UsersRepositoryImpl
    ): UsersRepository


    @Binds
    fun bindsForestRepositoryImpl(
        implementation: ForestRepositoryImpl
    ): ForestRepository


    @Binds
    fun bindsCurrentUserRepositoryImpl(
        implementation: CurrentUserRepositoryImpl
    ): CurrentUserRepository

    @Binds
    fun bindsLoginRepositoryImpl(
        implementation: LoginRepositoryImpl
    ): LoginRepository


}