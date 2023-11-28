package com.development.gocipes.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.core.R
import com.development.gocipes.core.databinding.ItemCookBinding
import com.development.gocipes.core.model.Cook
import com.development.gocipes.core.utils.Extensions.showImage

class CookAdapter : ListAdapter<Cook, CookAdapter.CookViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookViewHolder {
        val binding = ItemCookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CookViewHolder(private val binding: ItemCookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cook: Cook) {
            binding.apply {
                sivCook.showImage(itemView.context, cook.imageUrl)
                tvStep.text = itemView.context.getString(R.string.by_step, cook.id.toString())
                tvDescription.text = cook.description
            }
        }
    }

    companion object {
        val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Cook>() {
                override fun areItemsTheSame(oldItem: Cook, newItem: Cook) = oldItem == newItem

                override fun areContentsTheSame(oldItem: Cook, newItem: Cook) = oldItem == newItem
            }
    }
}