package com.example.animalsworldapp.data.cloud.models.fauna


import android.os.Parcelable
import com.example.animalsworldapp.data.cloud.models.common.Image
import com.example.animalsworldapp.data.cloud.models.common.LocationImage
import com.example.animalsworldapp.data.cloud.models.common.Voice
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FaunaCloud(
    @SerializedName("about_fauna")
    val aboutFauna: String,
    @SerializedName("background_image")
    val backgroundImage: Image,
    @SerializedName("classes")
    val classes: String,
    @SerializedName("videoUri")
    val videoUri: String,
    @SerializedName("dharacteristics_detail")
    val characteristicsDetail: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("interesting_fact")
    val interestingFact: String?,
    @SerializedName("location")
    val location: String,
    @SerializedName("location_image")
    val locationImage: LocationImage,
    @SerializedName("name")
    val name: String,
    @SerializedName("voice")
    val voice: Voice?,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("updatedAt")
    val updatedAt: String
) : Parcelable