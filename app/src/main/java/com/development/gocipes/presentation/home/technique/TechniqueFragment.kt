package com.development.gocipes.presentation.home.technique

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.development.gocipes.databinding.FragmentTechniqueBinding
import com.development.gocipes.core.presentation.adapter.InformationGridAdapter

class TechniqueFragment : Fragment() {

    private var _binding: FragmentTechniqueBinding? = null
    private val binding get() = _binding
    private lateinit var informationGridAdapter: InformationGridAdapter

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
        informationGridAdapter = InformationGridAdapter { information ->
            navigateToDetailTechnique(information)
        }
        val listArticle = com.development.gocipes.core.data.DummyInformation.dummyTechnique
        val gridCount =
            if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 4

        binding?.apply {
            rvArticle.apply {
                adapter = informationGridAdapter
                layoutManager = GridLayoutManager(requireActivity(), gridCount)
            }
        }

        informationGridAdapter.submitList(listArticle)
    }

    private fun navigateToDetailTechnique(information: com.development.gocipes.core.model.Information) {
        val action =
            TechniqueFragmentDirections.actionTechniqueFragmentToDetailTechniqueFragment(
                information
            )
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}