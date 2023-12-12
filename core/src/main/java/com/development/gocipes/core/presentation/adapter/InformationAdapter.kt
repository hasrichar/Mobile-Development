package com.development.gocipes.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.core.databinding.ItemGuideBinding
import com.development.gocipes.core.domain.model.information.Information
import com.development.gocipes.core.utils.Extensions.showImage

class InformationAdapter(val data: (Information) -> Unit) :
    ListAdapter<Information, InformationAdapter.GuideViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val binding = ItemGuideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GuideViewHolder(private val binding: ItemGuideBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(information: Information) {
            binding.apply {
                sivGuide.showImage(itemView.context, information.imageUrl)
                tvName.text = information.name
            }
            itemView.setOnClickListener { data.invoke(information) }
        }

    }

    companion object {
        val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Information>() {
                override fun areItemsTheSame(oldItem: Information, newItem: Information) =
                    oldItem == newItem

                override fun areContentsTheSame(oldItem: Information, newItem: Information) =
                    oldItem == newItem
            }
    }
}