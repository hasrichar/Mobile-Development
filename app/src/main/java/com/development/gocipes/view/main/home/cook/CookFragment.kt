package com.development.gocipes.view.main.home.cook

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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.databinding.FragmentCookBinding
import com.development.gocipes.model.Cook
import com.development.gocipes.model.Food
import com.development.gocipes.view.main.home.adapter.CookAdapter

class CookFragment : Fragment() {

    private var _binding: FragmentCookBinding? = null
    private val binding get() = _binding
    private val navArgs by navArgs<CookFragmentArgs>()
    private lateinit var cookAdapter: CookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCookBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodArgs = navArgs.food

        setupView(foodArgs)
    }

    private fun setupView(food: Food) {

        setupToolbar()
        setupRecyclerView(food.step)
        binding?.btnCook?.setOnClickListener { navigateToTimer(food) }
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = "Langkah-langkah"
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

    private fun setupRecyclerView(listCook: List<Cook>) {
        cookAdapter = CookAdapter()

        binding?.rvCook?.apply {
            adapter = cookAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        cookAdapter.submitList(listCook)
    }

    private fun navigateToTimer(food: Food) {
        val action =
            CookFragmentDirections.actionCookFragmentToTimerFragment(
                food
            )
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}