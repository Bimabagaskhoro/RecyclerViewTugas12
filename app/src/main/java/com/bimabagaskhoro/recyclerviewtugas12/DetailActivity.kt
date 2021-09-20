package com.bimabagaskhoro.recyclerviewtugas12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Item"
        actionbar.setDisplayHomeAsUpEnabled(true)
        showDetail()
    }

    private fun showDetail() {
        val tvName: TextView = findViewById(R.id.tv_name_detail)
        val tvPrice: TextView = findViewById(R.id.tv_price_detail)
        val imgAvatar: ImageView = findViewById(R.id.img_item_detail)

        val item = intent.getParcelableExtra<Item>(EXTRA_DATA) as Item

        tvName.text = item.name
        tvPrice.text = item.price
        Glide.with(this)
            .load(item.avatar)
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