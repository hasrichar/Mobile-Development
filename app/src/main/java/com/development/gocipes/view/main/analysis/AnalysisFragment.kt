package com.development.gocipes.view.main.analysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.data.DummyFavorite
import com.development.gocipes.data.DummyIngridients
import com.development.gocipes.databinding.FragmentAnalysisBinding
import com.development.gocipes.model.Analysis
import com.development.gocipes.model.Favorite
import com.development.gocipes.view.main.analysis.adapter.AnalysisAdapter
import com.development.gocipes.view.main.favorite.adapter.FavoriteAdapter

class AnalysisFragment : Fragment() {

    private var _binding: FragmentAnalysisBinding? = null
    private val binding get() = _binding
    private lateinit var adapterAnalysis: AnalysisAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnalysisBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
    }

    private fun setupRecycler() {
        val listAnalysis = DummyIngridients.dummyIngridient
        adapterAnalysis = AnalysisAdapter { analysis -> }
        binding?.apply {
            rvAnalysis.apply {
                adapter = adapterAnalysis
                layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL, false)
            }
        }
        adapterAnalysis.submitList(listAnalysis)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}