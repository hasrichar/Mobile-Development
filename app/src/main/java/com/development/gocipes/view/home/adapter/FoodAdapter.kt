package com.development.gocipes.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.databinding.ItemFoodBinding
import com.development.gocipes.model.Food
import com.development.gocipes.utils.Extensions.showImage

class FoodAdapter(val data: (Food) -> Unit) : ListAdapter<Food, FoodAdapter.FoodViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FoodViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.apply {
                sivFood.showImage(itemView.context, food.imageUrl)
                tvName.text = food.name
                tvMinutes.text = food.minutes
            }

            itemView.setOnClickListener { data.invoke(food) }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Food, newItem: Food) =
                oldItem == newItem
        }
    }
}