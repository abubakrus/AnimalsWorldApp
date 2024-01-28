package com.example.animalsworldapp.data.cloud.models.users


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersCloud(
    @SerializedName("about")
    val about: String,
    @SerializedName("avatar")
    val avatar: AvatarImageCloud?,
    @SerializedName("contact_with_me")
    val contactWithMe: String?,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nick_name")
    val nickName: String,
    @SerializedName("objectId")
    val id: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
) : Parcelable