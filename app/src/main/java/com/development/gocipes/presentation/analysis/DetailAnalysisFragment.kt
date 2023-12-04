package com.development.gocipes.presentation.analysis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.development.gocipes.R
import com.development.gocipes.core.model.Analysis
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.databinding.FragmentDetailAnalysisBinding


class DetailAnalysisFragment : Fragment() {
    private var _binding: FragmentDetailAnalysisBinding? = null
    private val binding get() = _binding
    private val navArgs by navArgs<DetailAnalysisFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailAnalysisBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val analysisArgs = navArgs.analysis
        setupView(analysisArgs)
        setupToolbar()

    }

    private fun setupView(analysis: Analysis) {
        binding?.apply {
            ivIngridient.showImage(requireActivity(), analysis.imageUrl)
            tvNameIngridient.text = analysis.name
            tvNameAnalysis.text = analysis.name
            tvEnergyTotal.text = getString(com.development.gocipes.core.R.string.kilo_kalori, analysis.energi.toString())
            tvProteinTotal.text =  getString(com.development.gocipes.core.R.string.gram, analysis.protein.toString())
            tvLemakTotal.text =  getString(com.development.gocipes.core.R.string.gram, analysis.lemak.toString())
            tvKarboTotal.text =  getString(com.development.gocipes.core.R.string.gram, analysis.karbo.toString())
        }
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = getString(com.development.gocipes.core.R.string.bahan)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}