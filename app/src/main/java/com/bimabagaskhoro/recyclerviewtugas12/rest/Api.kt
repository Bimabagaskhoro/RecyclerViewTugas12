package com.bimabagaskhoro.recyclerviewtugas12.rest

import com.bimabagaskhoro.recyclerviewtugas12.model.DetailMovieResponse
import com.bimabagaskhoro.recyclerviewtugas12.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("movie/popular?api_key=8152b136a5dad36d2ca7844f884577ba&language=en&page=1")
    fun getMovie(): Call<MovieResponse>

    @GET("movie/{movie_id}?api_key=8152b136a5dad36d2ca7844f884577ba&language=en&page=1")
    fun getMovieDetail(
        @Path("movie_id") movie_id: Int
    ): Call<DetailMovieResponse>
}