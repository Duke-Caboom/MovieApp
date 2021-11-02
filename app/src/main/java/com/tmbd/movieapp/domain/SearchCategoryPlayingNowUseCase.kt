package com.tmbd.themovieapp.domain

import com.tmbd.themovieapp.data.MovieRepository
import com.tmbd.themovieapp.data.models.MovieModel

class SearchCategoryPlayingNowUseCase {
    private val  repository= MovieRepository()
    suspend operator fun invoke(): List<MovieModel>?{
        return repository.getMoviesNowPlaying()
    }
}