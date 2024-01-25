package com.example.animalsworldapp.di

import com.example.animalsworldapp.domain.repositories.CurrentUserRepository
import com.example.animalsworldapp.domain.repositories.FaunaRepository
import com.example.animalsworldapp.domain.repositories.FloraRepository
import com.example.animalsworldapp.domain.repositories.ForestRepository
import com.example.animalsworldapp.domain.repositories.LoginRepository
import com.example.animalsworldapp.domain.repositories.MountainRepository
import com.example.animalsworldapp.domain.repositories.ShowedOnBoardingRepository
import com.example.animalsworldapp.domain.repositories.UsersRepository
import com.example.animalsworldapp.domain.usecases.SetOnBoardingShowedUseCase
import com.example.animalsworldapp.domain.usecases.SetOnBoardingShowedUseCaseImpl
import com.example.animalsworldapp.domain.usecases.ShouldOnBoardingPassedUseCase
import com.example.animalsworldapp.domain.usecases.ShouldOnBoardingPassedUseCaseImpl
import com.example.animalsworldapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.example.animalsworldapp.domain.usecases.current_user.SaveCurrentUserUseCaseImpl
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchAllFaunaUseCase
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchAllFaunaUseCaseImpl
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchFaunaByIdUseCase
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchFaunaByIdUseCaseImpl
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchLimitFaunaUseCase
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchLimitFaunaUseCaseImpl
import com.example.animalsworldapp.domain.usecases.fauna_usecase.SearchByQueryFaunaUseCase
import com.example.animalsworldapp.domain.usecases.fauna_usecase.SearchByQueryFaunaUseCaseImpl
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchAllFloraUseCase
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchAllFloraUseCaseImpl
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchFloraByIdUseCase
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchFloraByIdUseCaseImpl
import com.example.animalsworldapp.domain.usecases.forests.FetchAllForestsUseCase
import com.example.animalsworldapp.domain.usecases.forests.FetchAllForestsUseCaseImpl
import com.example.animalsworldapp.domain.usecases.forests.FetchForestByIdUseCase
import com.example.animalsworldapp.domain.usecases.forests.FetchForestByIdUseCaseImpl
import com.example.animalsworldapp.domain.usecases.forests.FetchLimitForestUseCase
import com.example.animalsworldapp.domain.usecases.forests.FetchLimitForestUseCaseImpl
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchAllMountainUseCase
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchAllMountainUseCaseImpl
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchLimitMountainUseCase
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchLimitMountainUseCaseImpl
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchMountainByIdUseCase
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchMountainByIdUseCaseImpl
import com.example.animalsworldapp.domain.usecases.signin.SingInUseCase
import com.example.animalsworldapp.domain.usecases.signin.SingInUseCaseImpl
import com.example.animalsworldapp.domain.usecases.signup.SignUpUseCase
import com.example.animalsworldapp.domain.usecases.signup.SignUpUseCaseImpl
import com.example.animalsworldapp.domain.usecases.user.FetchCurrentUserUseCase
import com.example.animalsworldapp.domain.usecases.user.FetchCurrentUserUseCaseImpl
import com.example.animalsworldapp.domain.usecases.user.FetchUserByIdUseCase
import com.example.animalsworldapp.domain.usecases.user.FetchUserByIdUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideSetOnBoardingShowedUseCase(
        repository: ShowedOnBoardingRepository
    ): SetOnBoardingShowedUseCase = SetOnBoardingShowedUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideIsOnBoardingPassedUseCase(
        repository: ShowedOnBoardingRepository
    ): ShouldOnBoardingPassedUseCase = ShouldOnBoardingPassedUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchAllFaunaUseCase(
        repository: FaunaRepository
    ): FetchAllFaunaUseCase = FetchAllFaunaUseCaseImpl(
        faunaRepository = repository
    )

    @Provides
    fun provideFetchAllFloraUseCaseImpl(
        repository: FloraRepository
    ): FetchAllFloraUseCase = FetchAllFloraUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchAllMountainUseCaseImpl(
        repository: MountainRepository
    ): FetchAllMountainUseCase = FetchAllMountainUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchFaunaByIdUseCase(
        repository: FaunaRepository
    ): FetchFaunaByIdUseCase = FetchFaunaByIdUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchFloraByIdUseCase(
        repository: FloraRepository
    ): FetchFloraByIdUseCase = FetchFloraByIdUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchMountainByIdUseCase(
        repository: MountainRepository
    ): FetchMountainByIdUseCase = FetchMountainByIdUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchLimitFaunaUseCaseImpl(
        repository: FaunaRepository
    ): FetchLimitFaunaUseCase = FetchLimitFaunaUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchLimitMountainUseCaseImpl(
        repository: MountainRepository
    ): FetchLimitMountainUseCase = FetchLimitMountainUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchUserByIdUseCaseImpl(
        repository: UsersRepository
    ): FetchUserByIdUseCase = FetchUserByIdUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchAllForestsUseCaseImpl(
        repository: ForestRepository
    ): FetchAllForestsUseCase = FetchAllForestsUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchForestByIdUseCaseImpl(
        repository: ForestRepository
    ): FetchForestByIdUseCase = FetchForestByIdUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchLimitForestUseCaseImpl(
        repository: ForestRepository
    ): FetchLimitForestUseCase = FetchLimitForestUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideFetchCurrentUserUseCaseImpl(
        repository: CurrentUserRepository
    ): FetchCurrentUserUseCase = FetchCurrentUserUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideSaveCurrentUserUseCaseImpl(
        repository: CurrentUserRepository
    ): SaveCurrentUserUseCase = SaveCurrentUserUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideSingInUseCaseImpl(
        repository: LoginRepository
    ): SingInUseCase = SingInUseCaseImpl(
        repository = repository
    )

    @Provides
    fun provideSignUpUseCaseImpl(
        repository: LoginRepository,
        userRepository: UsersRepository
    ): SignUpUseCase = SignUpUseCaseImpl(
        repository = repository,
        userRepository = userRepository
    )

    @Provides
    fun provideSearchByQueryFaunaUseCaseImpl(
        repository: FaunaRepository,
    ): SearchByQueryFaunaUseCase = SearchByQueryFaunaUseCaseImpl(
        repository = repository,
    )

}