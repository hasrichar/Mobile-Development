package com.development.gocipes.presentation.analysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.core.data.dummy.DummyIngridients
import com.development.gocipes.core.model.Analysis
import com.development.gocipes.databinding.FragmentAnalysisBinding
import com.development.gocipes.core.presentation.adapter.AnalysisAdapter

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
        adapterAnalysis = AnalysisAdapter { analysis ->
            navigateToDetail(analysis)
        }
        binding?.apply {
            rvAnalysis.apply {
                adapter = adapterAnalysis
                layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL, false)
            }
        }
        adapterAnalysis.submitList(listAnalysis)
    }

    private fun navigateToDetail(analysis: Analysis) {
        val action = AnalysisFragmentDirections.actionAnalysisFragmentToDetailAnalysisFragment(analysis)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}