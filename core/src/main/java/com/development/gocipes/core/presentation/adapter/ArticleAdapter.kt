package com.development.gocipes.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.core.data.remote.response.article.ArtikelItem
import com.development.gocipes.core.databinding.ItemGuideBinding
import com.development.gocipes.core.domain.model.technique.Technique
import com.development.gocipes.core.presentation.adapter.TechniqueGridAdapter.Companion.DIFF_CALLBACK
import com.development.gocipes.core.utils.Extensions.showImage

class ArticleAdapter() :
    ListAdapter<ArtikelItem, ArticleAdapter.GuideViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val binding = ItemGuideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class GuideViewHolder(private val binding: ItemGuideBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(artikelItem: ArtikelItem) {
            binding.apply {
                sivGuide.showImage(itemView.context, artikelItem.gambar)
                tvName.text = artikelItem.headline
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArtikelItem>() {
            override fun areItemsTheSame(oldItem: ArtikelItem, newItem: ArtikelItem) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ArtikelItem, newItem: ArtikelItem) =
                oldItem == newItem
        }
    }
}