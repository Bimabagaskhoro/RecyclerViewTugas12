package com.bimabagaskhoro.recyclerviewtugas12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.recyclerviewtugas12.adapter.ItemAdapter
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ActivityMainBinding
import com.bimabagaskhoro.recyclerviewtugas12.model.MovieResponse
import com.bimabagaskhoro.recyclerviewtugas12.model.ResultsItem
import com.bimabagaskhoro.recyclerviewtugas12.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity(){
    val itemAdapter = ItemAdapter(arrayListOf())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.home)

        binding.apply {
            rvItem.layoutManager = LinearLayoutManager(this@MainActivity)
            rvItem.setHasFixedSize(true)
            rvItem.adapter = itemAdapter
            getDataMovie()
        }
    }

    private fun getDataMovie() {
        RetrofitClient.apiInstance.getMovie()
            .enqueue(object : Callback<MovieResponse>{
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful){
                        showMovie(response.body())
                    }else{
                        Toast.makeText(this@MainActivity, "Reponse Gagal", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Reponse Gagal : $t", Toast.LENGTH_LONG).show()
                }

            })
    }

    private fun showMovie(data: MovieResponse?){
        val result = data?.results
        itemAdapter.setShow(result as List<ResultsItem>)
        //showLoading(true)
    }
    private fun showLoading(state: Boolean) {
        if (state) {
            binding.apply {
                progressBar.visibility = View.VISIBLE
                rvItem.visibility = View.INVISIBLE
            }
        } else {
            binding.apply {
                progressBar.visibility = View.INVISIBLE
                rvItem.visibility = View.VISIBLE
            }
        }
    }
}