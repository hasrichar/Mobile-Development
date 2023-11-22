package com.development.gocipes.view.main.home.food

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
import com.development.gocipes.data.DummyFood
import com.development.gocipes.databinding.FragmentFoodBinding
import com.development.gocipes.model.Food
import com.development.gocipes.view.main.home.adapter.FoodGridAdapter

class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding
    private lateinit var foodGridAdapter: FoodGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupToolbar()
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = "Makanan Paling Unggul"
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
        val foodList = DummyFood.dummyFood
        val gridCount = if (requireActivity().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 4

        foodGridAdapter = FoodGridAdapter { food ->
            navigateToDetail(food)
        }

        binding?.rvFood?.apply {
            layoutManager = GridLayoutManager(requireActivity(), gridCount)
            adapter = foodGridAdapter
            setHasFixedSize(true)
        }

        foodGridAdapter.submitList(foodList)
    }

    private fun navigateToDetail(food: Food) {
        val action =
            FoodFragmentDirections.actionFoodFragmentToDetailFoodFragment(
                food
            )
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}