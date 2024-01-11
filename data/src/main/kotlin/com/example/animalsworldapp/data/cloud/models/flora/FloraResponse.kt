package com.example.animalsworldapp.data.cloud.models.flora

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FloraResponse(
    @SerializedName("results")
    val results: List<FloraCloud>
) : Parcelable