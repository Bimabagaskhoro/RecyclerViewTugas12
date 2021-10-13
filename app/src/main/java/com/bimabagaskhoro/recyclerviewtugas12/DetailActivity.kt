package com.bimabagaskhoro.recyclerviewtugas12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ActivityDetailBinding
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ActivityMainBinding
import com.bimabagaskhoro.recyclerviewtugas12.model.DetailMovieResponse
import com.bimabagaskhoro.recyclerviewtugas12.model.ResultsItem
import com.bimabagaskhoro.recyclerviewtugas12.mvp.detail.DetailMovieContract
import com.bimabagaskhoro.recyclerviewtugas12.mvp.detail.DetailMoviePresenter
import com.bumptech.glide.Glide

@Suppress("CAST_NEVER_SUCCEEDS")
class DetailActivity : AppCompatActivity(), View.OnClickListener, DetailMovieContract{
    private lateinit var binding: ActivityDetailBinding
    companion object {
        const val EXTRA_LINK = "https://image.tmdb.org/t/p/w500"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Item"
        actionbar.setDisplayHomeAsUpEnabled(true)

        var id = intent.getStringExtra("id_movie")
        DetailMoviePresenter(this).getDetailMovie(id)

        //showDetail()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_buy_item -> {
                Toast.makeText(this, "You Like This Movies", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onMovieSuccess(item: DetailMovieResponse) {
        binding.tvNameDetail.text = item.originalTitle
        binding.tvPriceDetail.text = item.overview
        Glide.with(this)
            .load(EXTRA_LINK+item.posterPath)
            .into(binding.imgItemDetail)
    }

    override fun onMovieFailed(t: Throwable) {
        Toast.makeText(this@DetailActivity, "Reponse Gagal", Toast.LENGTH_LONG).show()
    }
}