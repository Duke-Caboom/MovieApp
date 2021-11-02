package com.tmbd.themovieapp.data.network

import com.tmbd.themovieapp.data.models.MovieModel
import com.tmbd.themovieapp.data.models.SearchCategoryModel
import com.tmbd.themovieapp.data.models.SearchMediaForMovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiClient {
    //https://api.themoviedb.org/3/movie/now_playing?api_key=6dd1dd535ed10c4a70124d3054538e06&page=1
    @GET("/3/movie/now_playing")
    suspend fun getMoviesNowPlaying(
        @Query("api_key") key: String?,
        @Query("page") page: Int
    ): Response<SearchCategoryModel>

    //https://api.themoviedb.org/3/movie/popular?api_key=6dd1dd535ed10c4a70124d3054538e06&page=1
    @GET("/3/movie/popular")
    suspend fun getMoviesMostPopular(
        @Query("api_key") key: String?,
        @Query("page") page: Int
    ): Response<SearchCategoryModel>


    @GET("/3/movie/{movie_id}/videos")
    suspend fun getMediaForMovie(
        @Path("movie_id") movie_id: String,
        @Query("api_key") api_key: String?
    ): Response<SearchMediaForMovieModel>
}