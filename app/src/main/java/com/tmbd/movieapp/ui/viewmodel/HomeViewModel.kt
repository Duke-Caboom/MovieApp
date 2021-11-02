package com.tmbd.movieapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tmbd.themovieapp.data.models.MovieModel
import com.tmbd.themovieapp.domain.SearchCategoryMostPopularUseCase
import com.tmbd.themovieapp.domain.SearchCategoryPlayingNowUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private var searchCategoryPlayingNowUseCase= SearchCategoryPlayingNowUseCase()
    private val moviePlayingNowModel = MutableLiveData<List<MovieModel>>()
    var _moviePlayingNowModel: LiveData<List<MovieModel>> = moviePlayingNowModel

    private var searchCategoryMostPopularUseCase= SearchCategoryMostPopularUseCase ()
    private val movieMostPopularModel = MutableLiveData<List<MovieModel>>()
    var _movieMostPopularModel: LiveData<List<MovieModel>> = movieMostPopularModel

    val isLoading= MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<MovieModel>? = searchCategoryPlayingNowUseCase()
            result?.let {
                moviePlayingNowModel.value = it
            }
            isLoading.postValue(false)
        }

        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<MovieModel>? = searchCategoryMostPopularUseCase()
            result?.let {
                movieMostPopularModel.value = it
            }
            isLoading.postValue(false)
        }
    }

}