package com.tmbd.themovieapp.data

import com.tmbd.themovieapp.data.models.MovieMediaModel
import com.tmbd.themovieapp.data.models.MovieModel
import com.tmbd.themovieapp.data.network.MovieService

class MovieRepository {
    private val api = MovieService()

    suspend fun getMoviesNowPlaying(): List<MovieModel> {
        return api.getMoviesNowPlaying()
    }

    suspend fun getMoviesMostPopular(): List<MovieModel>? {
        return api.getMoviesMostPopular()
    }

    suspend fun getMediaForMovie(idPelicula: Int): List<MovieMediaModel>? {
        return api.getMediaForMovie(idPelicula)
    }

}