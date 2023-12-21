package com.development.gocipes.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.core.databinding.ItemFoodGridBinding
import com.development.gocipes.core.domain.model.food.Food
import com.development.gocipes.core.presentation.adapter.FoodAdapter.Companion.DIFF_CALLBACK
import com.development.gocipes.core.utils.Extensions.showImage

class FoodGridAdapter(val data: (Food) -> Unit) : ListAdapter<Food, FoodGridAdapter.FoodGridViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodGridViewHolder {
        val binding =
            ItemFoodGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodGridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodGridViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FoodGridViewHolder(private val binding: ItemFoodGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.apply {
                sivFood.showImage(itemView.context, food.imageUrl)
                tvName.text = food.name
                tvMinutes.text = food.minutes
                tvCategory.text = food.category
            }

            itemView.setOnClickListener { data.invoke(food) }
        }
    }
}