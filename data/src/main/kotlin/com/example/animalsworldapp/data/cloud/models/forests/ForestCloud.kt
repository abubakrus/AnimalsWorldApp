package com.example.animalsworldapp.data.cloud.models.forests


import android.os.Parcelable
import com.example.animalsworldapp.data.cloud.models.common.BackgroundImage
import com.example.animalsworldapp.data.cloud.models.common.Image
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForestCloud(
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
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("objectId")
    val id: String,
    @SerializedName("updatedAt")
    val updatedAt: String
) : Parcelable