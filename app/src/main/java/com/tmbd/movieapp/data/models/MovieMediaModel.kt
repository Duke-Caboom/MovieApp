package com.tmbd.themovieapp.data.models

import com.google.gson.annotations.SerializedName

data class MovieMediaModel (
    @SerializedName("iso_639_1") val iso_1: String,
    @SerializedName("iso_3166_1") val iso_2: String,
    @SerializedName("name") val name: String,
    @SerializedName("key") val key: String,
    @SerializedName("site") val site: String,
    @SerializedName("size") val size: Int,
    @SerializedName("type") val type: String,
    @SerializedName("official") val isOfficial: Boolean,
    @SerializedName("published_at") val published_at: String,
    @SerializedName("id") val id: String,
    )