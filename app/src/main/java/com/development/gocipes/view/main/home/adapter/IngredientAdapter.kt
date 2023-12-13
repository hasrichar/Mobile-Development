package com.development.gocipes.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.R
import com.development.gocipes.databinding.ItemIngredientsBinding
import com.development.gocipes.model.Ingredient

class IngredientAdapter : ListAdapter<Ingredient, IngredientAdapter.IngredientViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val binding = ItemIngredientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class IngredientViewHolder(private val binding: ItemIngredientsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Ingredient) {
            binding.tvIngredients.text =
                itemView.context.getString(R.string.item_ingredients, ingredient.description)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Ingredient>() {
            override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient) =
                oldItem == newItem
        }
    }
}