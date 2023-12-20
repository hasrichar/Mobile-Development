package com.development.gocipes.presentation.home.food.cook

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import com.development.gocipes.core.domain.model.food.Cook
import com.development.gocipes.core.domain.model.food.Food
import com.development.gocipes.core.presentation.adapter.CookAdapter
import com.development.gocipes.databinding.FragmentCookBinding

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
        setupShimmer()
    }

    private fun setupShimmer() {
        binding?.apply {
            rvCook.visibility = View.INVISIBLE
            toolbar.visibility = View.INVISIBLE
            btnCook.visibility = View.INVISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                rvCook.visibility = View.VISIBLE
                toolbar.visibility = View.VISIBLE
                btnCook.visibility = View.VISIBLE
                shimmer.apply {
                    stopShimmer()
                    visibility = View.INVISIBLE
                }
            }, 1000)
        }
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