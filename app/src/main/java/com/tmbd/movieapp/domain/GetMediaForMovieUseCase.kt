package com.tmbd.themovieapp.domain

import com.tmbd.themovieapp.data.MovieRepository
import com.tmbd.themovieapp.data.models.MovieMediaModel

class GetMediaForMovieUseCase {
    private val  repository= MovieRepository()
    suspend operator fun invoke(idPelicula: Int): List<MovieMediaModel>?{
        return repository.getMediaForMovie(idPelicula)
    }
}