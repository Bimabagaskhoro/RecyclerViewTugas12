package com.bimabagaskhoro.recyclerviewtugas12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.home)

        val adapter = ItemAdapter(getlistItem()){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, it)
            startActivity(intent)
        }
        
        binding.apply {
            rvItem.layoutManager = LinearLayoutManager(this@MainActivity)
            rvItem.setHasFixedSize(true)
            rvItem.adapter = adapter
        }
    }

    private fun getlistItem(): ArrayList<Item> {
        val name = resources.getStringArray(R.array.name)
        val price = resources.getStringArray(R.array.price)
        val avatar = resources.getStringArray(R.array.avatar)

        val listItem = ArrayList<Item>()
        for (i in name.indices) {
            val item = Item(
                name[i],
                price[i],
                avatar[i]
            )
            listItem.add(item)
        }
        return listItem
    }
}