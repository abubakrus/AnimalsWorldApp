package com.example.animalsworldapp.data.repositories

import android.content.Context
import com.example.animalsworldapp.domain.repositories.ShowedOnBoardingRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val SETTINGS_SHARED_PREF_NAME = "on_boarding_file"
private const val IS_ON_BOARDING_PASSED_NAME = "is_on_boarding_passed"

class ShowedOnBoardingRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ShowedOnBoardingRepository {

    private val sharedPreferences by lazy(LazyThreadSafetyMode.NONE) {
        context.getSharedPreferences(SETTINGS_SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun setOnBoardingShowed() {
        sharedPreferences.edit()
            .putBoolean(IS_ON_BOARDING_PASSED_NAME, true)
            .apply()
    }

    override fun isOnBoardingPassed(): Boolean {
        return sharedPreferences.getBoolean(IS_ON_BOARDING_PASSED_NAME, false)
    }

    override fun clearOnBoarding() {
        sharedPreferences.edit()
            .putBoolean(IS_ON_BOARDING_PASSED_NAME, false)
            .apply()
    }
}