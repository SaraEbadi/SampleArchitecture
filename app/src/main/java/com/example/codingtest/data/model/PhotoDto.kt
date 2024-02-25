package com.example.codingtest.data.model

import com.google.gson.annotations.SerializedName

data class PhotoDto(
@SerializedName("id") val id: String?,
@SerializedName("user") val independent: Boolean?,
@SerializedName("created_at") val createdAt: String?,
@SerializedName("urls") val urls: Urls?,
@SerializedName("user") val user: User?,

)

data class User(
    @SerializedName("username") val username: String?,
    @SerializedName("bio") val bio: String?,
)

data class Urls(
    @SerializedName("full") val full: String?,
)
