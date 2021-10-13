package com.bimabagaskhoro.recyclerviewtugas12.mvp.movie

import android.content.Context
import com.bimabagaskhoro.recyclerviewtugas12.model.MovieResponse
import com.bimabagaskhoro.recyclerviewtugas12.model.ResultsItem
import com.bimabagaskhoro.recyclerviewtugas12.mvp.movie.MovieContract
import com.bimabagaskhoro.recyclerviewtugas12.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("NAME_SHADOWING", "UNCHECKED_CAST")
class MoviePresenter (context: Context){
    private var movieContext  = context as MovieContract
     fun getMovie() {
        RetrofitClient.apiInstance.getMovie()
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response!!.isSuccessful){
                        movieContext.onMovieSuccess(response.body()?.
                        results as List<ResultsItem>)
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    movieContext.onMovieFailed(t)
                }

            })
    }
}