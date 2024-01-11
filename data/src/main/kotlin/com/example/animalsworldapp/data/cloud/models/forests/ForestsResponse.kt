package com.example.animalsworldapp.data.cloud.models.forests


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForestsResponse(
    @SerializedName("results")
    val results: List<ForestCloud>
) : Parcelable