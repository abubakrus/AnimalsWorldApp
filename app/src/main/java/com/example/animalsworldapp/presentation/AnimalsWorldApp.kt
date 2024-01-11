package com.example.animalsworldapp.presentation

import android.app.Application
import com.example.animalsworldapp.di.APPLICATION_ID
import com.example.animalsworldapp.di.BASE_URL
import com.example.animalsworldapp.di.CLIENT_KEY
import com.parse.Parse
import dagger.hilt.android.HiltAndroidApp



@HiltAndroidApp
class AnimalsWorldApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Parse.enableLocalDatastore(this)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server(BASE_URL)
                .build()
        )
    }
}