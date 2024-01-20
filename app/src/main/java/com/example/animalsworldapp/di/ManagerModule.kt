package com.example.animalsworldapp.di


import com.example.animalsworldapp.presentation.manager.NavigatorManager
import com.example.animalsworldapp.presentation.manager.NavigatorManagerImpl
import com.example.animalsworldapp.presentation.manager.toast.ShowToastUseCase
import com.example.animalsworldapp.presentation.manager.toast.ToastManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface ManagerModule {

    @Binds
    @Singleton
    fun bindNavigatorManager(
        impl: NavigatorManagerImpl
    ): NavigatorManager

    @Binds
    @Singleton
    fun bindToastManager(
        impl: ToastManager
    ): ShowToastUseCase
}