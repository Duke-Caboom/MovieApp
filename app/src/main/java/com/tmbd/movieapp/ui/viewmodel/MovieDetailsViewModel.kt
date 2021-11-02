package com.tmbd.movieapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmbd.themovieapp.data.models.MovieMediaModel
import com.tmbd.themovieapp.domain.GetMediaForMovieUseCase
import kotlinx.coroutines.launch

class MovieDetailsViewModel : ViewModel() {
    private var getMediaForMovieUseCase= GetMediaForMovieUseCase()
    private val mediaForMovie = MutableLiveData<MovieMediaModel>()
    var _mediaForMovie: LiveData<MovieMediaModel> = mediaForMovie

    fun onCreate(idPelicula: Int?) {
        if (idPelicula == -1)
            return

        viewModelScope.launch {
            val result: List<MovieMediaModel>? = idPelicula?.let { getMediaForMovieUseCase(it) }
            result?.let {
                for (model in it){
                    if (model.type.equals("Trailer", true) && model.site.equals("YouTube", true))
                        mediaForMovie.value = model
                }
            }
        }
    }
}