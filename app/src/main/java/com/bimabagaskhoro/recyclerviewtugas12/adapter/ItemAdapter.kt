package com.bimabagaskhoro.recyclerviewtugas12.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.recyclerviewtugas12.DetailActivity
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ItemBinding
import com.bimabagaskhoro.recyclerviewtugas12.model.ResultsItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ItemAdapter(private val listItem: ArrayList<ResultsItem> ):
        RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    companion object {
        const val EXTRA_LINK = "https://image.tmdb.org/t/p/w500"
    }

    fun setShow(data: List<ResultsItem>) {
        listItem.clear()
        listItem.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder((view))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(EXTRA_LINK + item.posterPath)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgUser)
                tvName.text = item.originalTitle
                tvPrice.text = item.overview
                itemView.setOnClickListener {
                    val moveDetail = Intent(itemView.context,DetailActivity::class.java)
                    moveDetail.putExtra("id_movie", item.id.toString())
                    itemView.context.startActivity(moveDetail)
                }
            }
        }
    }
}