package com.example.animalsworldapp.data.repositories

import android.content.Context
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.CurrentUserRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


private val SETTINGS_SHARED_PREF_NAME = "on_boarding_file"
private val IS_ON_BOARDING_PASSED_NAME = "is_on_boarding_passed"
private val CURRENT_USER_NAME = "CURRENT_USER_NAME"

class CurrentUserRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : CurrentUserRepository {


    private val sharedPreferences by lazy(LazyThreadSafetyMode.NONE) {
        context.getSharedPreferences(SETTINGS_SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun saveCurrentUser(user: UsersDomain) {
        val prefEditor = sharedPreferences.edit()
        prefEditor.putString(CURRENT_USER_NAME, Gson().toJson(user))
        prefEditor.apply()
    }

    override fun fetchCurrentUser(): UsersDomain {
        return try {
            val json = sharedPreferences.getString(CURRENT_USER_NAME, String()) ?: String()
            Gson().fromJson(json, UsersDomain::class.java)
        } catch (e: Exception) {
            UsersDomain.unknown
        }
    }

    override fun clearCurrentUser() {
        val prefEditor = sharedPreferences.edit()
        prefEditor.putString(CURRENT_USER_NAME, String())
        prefEditor.apply()
    }
}
