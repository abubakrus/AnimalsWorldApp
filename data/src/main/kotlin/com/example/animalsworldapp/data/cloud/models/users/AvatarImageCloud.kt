package com.example.animalsworldapp.data.cloud.models.users


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AvatarImageCloud(
    @SerializedName("name")
    val name: String,
    @SerializedName("__type")
    val type: String,
    @SerializedName("url")
    val url: String?
) : Parcelable