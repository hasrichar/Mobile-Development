package com.development.gocipes.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.development.gocipes.core.databinding.ItemAnalysisBinding
import com.development.gocipes.core.model.Analysis
import com.development.gocipes.core.utils.Extensions.showImage

class AnalysisAdapter(val data: (Analysis) -> Unit) :
    ListAdapter<Analysis, AnalysisAdapter.AnalysisViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalysisViewHolder {
        val binding =
            ItemAnalysisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnalysisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnalysisViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AnalysisViewHolder(private val binding: ItemAnalysisBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(analysis: Analysis) {
            binding.apply {
                ivAnalysis.showImage(itemView.context, analysis.imageUrl)
                tvHeadIngridient.text = analysis.name
                tvDescIngridient.text = analysis.description
            }
            itemView.setOnClickListener { data.invoke(analysis) }
        }
    }

    companion object {
        val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Analysis>() {
                override fun areItemsTheSame(
                    oldItem: Analysis,
                    newItem: Analysis
                ) = oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: Analysis,
                    newItem: Analysis
                ) = oldItem == newItem
            }
    }
}