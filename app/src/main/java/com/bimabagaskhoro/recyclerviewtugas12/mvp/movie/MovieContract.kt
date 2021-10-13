package com.bimabagaskhoro.recyclerviewtugas12.mvp.movie


import com.bimabagaskhoro.recyclerviewtugas12.model.ResultsItem

interface MovieContract {
    fun onMovieSuccess(item: List<ResultsItem>)
    fun onMovieFailed(t: Throwable)

}