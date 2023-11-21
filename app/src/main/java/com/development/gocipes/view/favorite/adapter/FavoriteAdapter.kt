package com.development.gocipes.view.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.databinding.ItemFavoriteBinding
import com.development.gocipes.model.Favorite
import com.development.gocipes.utils.Extensions.showImage

class FavoriteAdapter : ListAdapter<Favorite, FavoriteAdapter.FavoriteViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FavoriteViewHolder(private val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favorite: Favorite) {
            val categoryNames = favorite.category.map { it.name }

            binding.apply {
                sivFavorite.showImage(itemView.context, favorite.imageUrl)
                tvTitle.text = favorite.name
                tvCategory.text = categoryNames.joinToString(", ")
                tvTimerContainer.tvTime.text = "20 menit"
            }
        }
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Favorite>() {
            override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite) =
                oldItem == newItem
        }
    }
}