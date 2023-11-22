package com.development.gocipes.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.databinding.ItemInformationGridBinding
import com.development.gocipes.model.Information
import com.development.gocipes.utils.Extensions.showImage
import com.development.gocipes.view.main.home.adapter.InformationAdapter.Companion.DIFF_CALLBACK

class InformationGridAdapter(val data: (Information) -> Unit) : ListAdapter<Information, InformationGridAdapter.InformationGridViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationGridViewHolder {
        val binding = ItemInformationGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InformationGridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InformationGridViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class InformationGridViewHolder(private val binding: ItemInformationGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(information: Information) {
            binding.apply {
                sivGuide.showImage(itemView.context, information.imageUrl)
                tvName.text = information.name
            }
            itemView.setOnClickListener { data.invoke(information) }
        }
    }
}