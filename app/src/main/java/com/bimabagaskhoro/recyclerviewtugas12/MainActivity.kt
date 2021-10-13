package com.bimabagaskhoro.recyclerviewtugas12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.recyclerviewtugas12.adapter.ItemAdapter
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ActivityMainBinding
import com.bimabagaskhoro.recyclerviewtugas12.model.ResultsItem
import com.bimabagaskhoro.recyclerviewtugas12.mvp.movie.MovieContract
import com.bimabagaskhoro.recyclerviewtugas12.mvp.movie.MoviePresenter

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity(), MovieContract {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.home)
        MoviePresenter(this).getMovie()
    }

    override fun onMovieSuccess(item: List<ResultsItem>) {
        val itemAdapter = ItemAdapter(item as ArrayList<ResultsItem>)
        binding.rvItem.layoutManager = LinearLayoutManager(this)
        binding.rvItem.adapter = itemAdapter
    }

    override fun onMovieFailed(t: Throwable) {
        Toast.makeText(this@MainActivity, "Reponse Gagal", Toast.LENGTH_LONG).show()
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