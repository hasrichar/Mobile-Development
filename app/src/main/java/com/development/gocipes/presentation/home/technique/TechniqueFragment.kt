package com.development.gocipes.presentation.home.technique

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.development.gocipes.core.data.local.dummy.DummyInformation
import com.development.gocipes.core.domain.model.information.Information
import com.development.gocipes.core.domain.model.technique.Technique
import com.development.gocipes.core.presentation.adapter.InformationAdapter
import com.development.gocipes.core.presentation.adapter.TechniqueGridAdapter
import com.development.gocipes.core.utils.Result
import com.development.gocipes.databinding.FragmentTechniqueBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechniqueFragment : Fragment() {

    private var _binding: FragmentTechniqueBinding? = null
    private val binding get() = _binding
    private lateinit var techniqueGridAdapter: TechniqueGridAdapter
    private lateinit var informationAdapter: InformationAdapter
    private val viewModel by viewModels<TechniqueViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechniqueBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupView()
    }

    private fun techniqueObserver() {
        viewModel.getAllTechnique().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                }
                is Result.Loading -> {

                }
                is Result.Success -> {
                    result.data
                }
            }
        }
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = "Teknik Memasak"
            }
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {}

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                findNavController().navigateUp()
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.CREATED)
    }

    private fun setupView() {
        val data = DummyInformation.dummyTechnique
        informationAdapter = InformationAdapter { technique ->
            navigateToTechniqueGraph(technique)
        }
        val gridCount =
            if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 4

        binding?.apply {
            rvArticle.apply {
                adapter = informationAdapter
                layoutManager = GridLayoutManager(requireActivity(), gridCount)
            }
        }

        informationAdapter.submitList(data)
    }

    private fun navigateToTechniqueGraph(information: Information) {
        val action = TechniqueFragmentDirections.actionTechniqueFragmentToTechniqueGraph(information)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}