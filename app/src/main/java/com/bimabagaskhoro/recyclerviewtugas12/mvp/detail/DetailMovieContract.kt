package com.bimabagaskhoro.recyclerviewtugas12.mvp.detail

import com.bimabagaskhoro.recyclerviewtugas12.model.DetailMovieResponse

interface DetailMovieContract {
    fun onMovieSuccess(item: DetailMovieResponse)
    fun onMovieFailed(t: Throwable)
}