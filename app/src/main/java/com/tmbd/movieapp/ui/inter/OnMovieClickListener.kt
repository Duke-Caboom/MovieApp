package com.tmbd.movieapp.ui.inter

import com.tmbd.themovieapp.data.models.MovieModel

interface OnMovieClickListener {
    fun onClickFragmentButton(movie: MovieModel)
}