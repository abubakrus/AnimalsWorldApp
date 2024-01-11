package com.example.animalsworldapp.data.cloud.models.fauna


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FaunaResponse(
    @SerializedName("results")
    val results: List<FaunaCloud>
):Parcelable