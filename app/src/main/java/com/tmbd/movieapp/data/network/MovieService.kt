package com.tmbd.themovieapp.data.network

import com.tmbd.themovieapp.data.models.MovieMediaModel
import com.tmbd.themovieapp.data.models.MovieModel
import com.tmbd.themovieapp.data.models.SearchCategoryModel
import com.tmbd.themovieapp.data.models.SearchMediaForMovieModel
import com.tmbd.themovieapp.util.Connect
import com.tmbd.themovieapp.util.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MovieService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getMoviesNowPlaying(): List<MovieModel> {
        return withContext(Dispatchers.IO){
            val response: Response<SearchCategoryModel> = retrofit.create(MovieApiClient::class.java).getMoviesNowPlaying(Connect().key, 1)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getMoviesMostPopular(): List<MovieModel>? {
        return withContext(Dispatchers.IO){
            val response: Response<SearchCategoryModel> = retrofit.create(MovieApiClient::class.java).getMoviesMostPopular(Connect().key, 1)
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getMediaForMovie(id: Int): List<MovieMediaModel>? {
        return withContext(Dispatchers.IO){
            val response: Response<SearchMediaForMovieModel> = retrofit.create(MovieApiClient::class.java).getMediaForMovie(id.toString(), Connect().key)
            response.body()?.results ?: emptyList()
        }
    }
}