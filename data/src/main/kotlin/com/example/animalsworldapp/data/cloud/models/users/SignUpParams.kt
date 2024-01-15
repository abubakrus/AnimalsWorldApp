package com.example.animalsworldapp.data.cloud.models.users

import com.google.gson.annotations.SerializedName

data class SignUpParams(
    @SerializedName("name")
    val name:String,
    @SerializedName("last_name")
    val lastName:String,
    @SerializedName("email")
    val email:String,
    @SerializedName("password")
    val password:String,

)
