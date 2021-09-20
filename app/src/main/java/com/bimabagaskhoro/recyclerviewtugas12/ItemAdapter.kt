package com.bimabagaskhoro.recyclerviewtugas12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.recyclerviewtugas12.databinding.ItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ItemAdapter(private val listItem: ArrayList<Item>, private val onClick: (Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder((view))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                Glide.with(itemView)
                    .load(item.avatar)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgUser)
                tvName.text = item.name
                tvPrice.text = item.price
            }
            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }
}