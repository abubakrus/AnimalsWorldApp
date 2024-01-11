package com.example.animalsworldapp.di

import com.example.animalsworldapp.data.cloud.service.FaunaService
import com.example.animalsworldapp.data.cloud.service.FloraService
import com.example.animalsworldapp.data.cloud.service.ForestService
import com.example.animalsworldapp.data.cloud.service.MountainService
import com.example.animalsworldapp.data.cloud.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://parseapi.back4app.com/classes/"
const val APPLICATION_ID = "9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x"
private const val REST_API_KEY = "fqUg4eBWtFuuBLxaFsm63jw0zXbJ7wtxbZYhDdqc"
const val CLIENT_KEY = "xZSyXaHJ1kzFSTDkzYiWvWSAA7eX8bWkdEtlAeU6"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(Interceptor { chain ->
                        val request = chain.request()
                            .newBuilder()
                            .addHeader(
                                name = "X-Parse-Application-Id",
                                value = APPLICATION_ID
                            )
                            .addHeader(
                                name = "X-Parse-REST-API-Key",
                                value = REST_API_KEY
                            ).addHeader(
                                name = "Content-Type",
                                value = "application/json"
                            )
                            .build()
                        return@Interceptor chain.proceed(request = request)
                    }).build()
            ).build()
    }


    @Provides
    fun provideFaunaService(
        retrofit: Retrofit
    ): FaunaService = retrofit.create(FaunaService::class.java)

    @Provides
    fun provideFloraService(
        retrofit: Retrofit
    ): FloraService = retrofit.create(FloraService::class.java)

    @Provides
    fun provideMountainService(
        retrofit: Retrofit
    ): MountainService = retrofit.create(MountainService::class.java)

    @Provides
    fun provideUsersService(
        retrofit: Retrofit
    ): UsersService = retrofit.create(UsersService::class.java)

    @Provides
    fun provideForestService(
        retrofit: Retrofit
    ): ForestService = retrofit.create(ForestService::class.java)
}