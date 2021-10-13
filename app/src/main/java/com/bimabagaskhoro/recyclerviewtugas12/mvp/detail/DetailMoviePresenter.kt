package com.bimabagaskhoro.recyclerviewtugas12.mvp.detail

import android.content.Context
import com.bimabagaskhoro.recyclerviewtugas12.model.DetailMovieResponse
import com.bimabagaskhoro.recyclerviewtugas12.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMoviePresenter (context: Context){
    private var detail  = context as DetailMovieContract
    fun getDetailMovie(id: String?) {
        RetrofitClient.apiInstance.getMovieDetail(id!!.toInt())
            .enqueue(object : Callback<DetailMovieResponse> {
                override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>
                ) {
                    if (response!!.isSuccessful){
                        detail.onMovieSuccess(response?.body()!!)
                    }
                }

                override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                    detail.onMovieFailed(t)
                }
            })
    }
}