package com.example.codingtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoModel(
    var id: String?,
    var independent: Boolean?,
    var createdAt: String?,
    var username: String?,
    var url: String?,
    var bio: String?,
    var isLiked: Boolean =false,
):Parcelable
