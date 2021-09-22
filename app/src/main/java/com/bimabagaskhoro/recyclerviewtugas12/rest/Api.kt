package com.bimabagaskhoro.recyclerviewtugas12.rest

import com.bimabagaskhoro.recyclerviewtugas12.model.MovieResponse
import com.bimabagaskhoro.recyclerviewtugas12.model.TvResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movie/popular?api_key=8152b136a5dad36d2ca7844f884577ba&language=en&page=1")
    fun getMovie(): Call<MovieResponse>
    @GET("tv/popular?api_key=8152b136a5dad36d2ca7844f884577ba&language=en&page=1")
    fun getTv(): Call<TvResponse>
}