package com.example.animalsworldapp.data.cloud.models.mountain

import android.os.Parcelable
import com.example.animalsworldapp.data.cloud.models.mountain.MountainCloud
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MountainResponse(
    @SerializedName("results")
    val results: List<MountainCloud>
) : Parcelable