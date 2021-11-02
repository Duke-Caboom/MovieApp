package com.tmbd.themovieapp.data.models;

import com.google.gson.annotations.SerializedName

data class SearchCategoryModel(
    @SerializedName("dates") val dates: MovieDatesModel,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<MovieModel>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Int
)
