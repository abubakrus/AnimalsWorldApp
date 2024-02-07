package com.example.animalsworldapp.data.cloud.models.mountain


import android.os.Parcelable
import com.example.animalsworldapp.data.cloud.models.common.BackgroundImage
import com.example.animalsworldapp.data.cloud.models.common.Image
import com.example.animalsworldapp.data.cloud.models.common.LocationImage
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MountainCloud(
    @SerializedName("about")
    val about: String,
    @SerializedName("background_image")
    val backgroundImage: BackgroundImage,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("interesting_fact")
    val interestingFact: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("location_image")
    val locationImage: LocationImage,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("updatedAt")
    val updatedAt: String
) : Parcelable