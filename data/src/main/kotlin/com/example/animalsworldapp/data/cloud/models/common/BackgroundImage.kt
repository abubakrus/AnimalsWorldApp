package com.example.animalsworldapp.data.cloud.models.common


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BackgroundImage(
    @SerializedName("name")
    val name: String,
    @SerializedName("__type")
    val type: String,
    @SerializedName("url")
    val url: String
) : Parcelable