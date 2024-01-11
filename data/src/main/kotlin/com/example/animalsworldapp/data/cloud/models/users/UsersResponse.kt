package com.example.animalsworldapp.data.cloud.models.users

import android.os.Parcelable
import com.example.animalsworldapp.data.cloud.models.users.UsersCloud
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersResponse(
    @SerializedName("results")
    val results: List<UsersCloud>
) : Parcelable