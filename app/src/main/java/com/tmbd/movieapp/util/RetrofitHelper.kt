package com.tmbd.themovieapp.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(Connect().urlConnectionAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}