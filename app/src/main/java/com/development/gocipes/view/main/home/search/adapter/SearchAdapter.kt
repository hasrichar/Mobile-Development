package com.development.gocipes.view.main.home.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.databinding.ItemSearchBinding
import com.development.gocipes.model.Food
import com.development.gocipes.utils.Extensions.showImage
import com.development.gocipes.view.main.home.adapter.FoodAdapter.Companion.DIFF_CALLBACK
import java.util.Locale

class SearchAdapter : ListAdapter<Food, SearchAdapter.SearchViewHolder>(DIFF_CALLBACK) {

    private var unFilteredList = listOf<Food>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.apply {
                sivFood.showImage(itemView.context, food.imageUrl)
                tvName.text = food.name
            }
        }
    }

    fun modifyList(list : List<Food>) {
        unFilteredList = list
        submitList(list)
    }

    fun filter(query: CharSequence?) {
        val list = mutableListOf<Food>()

        if(!query.isNullOrEmpty()) {
            list.addAll(unFilteredList.filter {
                it.name.lowercase(Locale.getDefault()).contains(query.toString().lowercase(Locale.getDefault())) })
        } else {
            list.addAll(unFilteredList)
        }

        submitList(list)
    }
}