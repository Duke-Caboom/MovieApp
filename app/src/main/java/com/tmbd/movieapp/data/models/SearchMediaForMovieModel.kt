package com.tmbd.themovieapp.data.models

import com.google.gson.annotations.SerializedName

data class SearchMediaForMovieModel(
    @SerializedName("id") val id: Int,
    @SerializedName("results") val results: List<MovieMediaModel>
)