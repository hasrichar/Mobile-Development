package com.development.gocipes.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.core.data.remote.response.article.ArtikelItem
import com.development.gocipes.core.databinding.ItemInformationGridBinding
import com.development.gocipes.core.domain.model.technique.Technique
import com.development.gocipes.core.presentation.adapter.ArticleAdapter.Companion.DIFF_CALLBACK
import com.development.gocipes.core.utils.Extensions.showImage

class ArticleGridAdapter(val data: (ArtikelItem) -> Unit) :
    ListAdapter<ArtikelItem, ArticleGridAdapter.InformationGridViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationGridViewHolder {
        val binding =
            ItemInformationGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InformationGridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InformationGridViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class InformationGridViewHolder(private val binding: ItemInformationGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(artikelItem: ArtikelItem) {
            binding.apply {
                sivGuide.showImage(itemView.context, artikelItem.gambar)
                tvName.text = artikelItem.headline
            }
            itemView.setOnClickListener { data.invoke(artikelItem) }
        }
    }
}