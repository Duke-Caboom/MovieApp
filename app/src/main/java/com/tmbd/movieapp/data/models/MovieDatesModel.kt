package com.tmbd.themovieapp.data.models

import com.google.gson.annotations.SerializedName

data class MovieDatesModel(
    @SerializedName("maximum") val maximum: String,
    @SerializedName("minimum") val minimum: String
)
