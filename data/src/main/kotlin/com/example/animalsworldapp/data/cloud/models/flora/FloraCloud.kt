package com.example.animalsworldapp.data.cloud.models.flora


import android.os.Parcelable
import com.example.animalsworldapp.data.cloud.models.common.BackgroundImage
import com.example.animalsworldapp.data.cloud.models.common.Image
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FloraCloud(
    @SerializedName("about_flora")
    val aboutFlora: String,
    @SerializedName("background_image")
    val backgroundImage: BackgroundImage,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("interesting_fact")
    val interestingFact: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("objectId")
    val objectId: String,
    @SerializedName("updatedAt")
    val updatedAt: String
):Parcelable