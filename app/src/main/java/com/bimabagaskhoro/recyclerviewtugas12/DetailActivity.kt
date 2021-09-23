package com.bimabagaskhoro.recyclerviewtugas12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ActivityDetailBinding
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ActivityMainBinding
import com.bimabagaskhoro.recyclerviewtugas12.model.ResultsItem
import com.bumptech.glide.Glide

@Suppress("CAST_NEVER_SUCCEEDS")
class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_LINK = "https://image.tmdb.org/t/p/w500"
    }
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Item"
        actionbar.setDisplayHomeAsUpEnabled(true)
        showDetail()
    }

    private fun showDetail() {
        val tvName: TextView = findViewById(R.id.tv_name_detail)
        val tvPrice: TextView = findViewById(R.id.tv_price_detail)
        val imgAvatar: ImageView = findViewById(R.id.img_item_detail)

        val item = intent.getParcelableExtra<ResultsItem>(EXTRA_DATA) as ResultsItem

        tvName.text = item.originalTitle
        tvPrice.text = item.overview
        Glide.with(this)
            .load(EXTRA_LINK+item.posterPath)
            .into(imgAvatar)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_buy_item -> {
                Toast.makeText(this, "You Buy this Item", Toast.LENGTH_SHORT).show()
            }
        }
    }
}