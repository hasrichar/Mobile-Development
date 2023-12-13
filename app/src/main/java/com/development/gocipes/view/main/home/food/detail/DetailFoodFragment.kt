package com.development.gocipes.view.main.home.food.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.R
import com.development.gocipes.databinding.FragmentDetailFoodBinding
import com.development.gocipes.model.Food
import com.development.gocipes.model.Ingredient
import com.development.gocipes.utils.Extensions.showImage
import com.development.gocipes.view.main.home.adapter.IngredientAdapter

class DetailFoodFragment : Fragment() {

    private var _binding: FragmentDetailFoodBinding? = null
    private val binding get() = _binding
    private val navArgs by navArgs<DetailFoodFragmentArgs>()
    private var menuDetail: Menu? = null
    private var statusFavorite: Boolean = false
    private lateinit var ingredientAdapter: IngredientAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailFoodBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodArgs = navArgs.food

        setupView(foodArgs)
        setupRecyclerIngredient(foodArgs.ingredients)
        setupToolbar(foodArgs)
    }

    private fun setupView(food: Food) {
        binding?.apply {
            contentDetail.apply {
                sivFood.showImage(requireActivity(), food.imageUrl)
                tvDescription.text = food.description
                tvMinutes.text = food.minutes
            }

            btnCook.setOnClickListener { navigateToCook(food) }
        }
    }

    private fun setupRecyclerIngredient(listIngredient: List<Ingredient>) {
        ingredientAdapter = IngredientAdapter()

        binding?.contentDetail?.rvIngredients?.apply {
            adapter = ingredientAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }

        ingredientAdapter.submitList(listIngredient)
    }

    private fun setupToolbar(food: Food) {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = food.name
            }
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_detail, menu)
                menuDetail = menu
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.btn_favorite -> {
                        statusFavorite = !statusFavorite
                        setIsFavorite(statusFavorite)
                        true
                    }

                    android.R.id.home -> {
                        requireActivity().onBackPressedDispatcher.onBackPressed()
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setIsFavorite(favorite: Boolean) {
        if (menuDetail == null) return
        val menuItem = menuDetail?.findItem(R.id.btn_favorite)
        if (favorite) {
            menuItem?.icon =
                ContextCompat.getDrawable(requireActivity(), R.drawable.ic_favorite)
        } else {
            menuItem?.icon =
                ContextCompat.getDrawable(requireActivity(), R.drawable.ic_favorite_border)
        }
    }

    private fun navigateToCook(food: Food) {
        val action =
            DetailFoodFragmentDirections.actionDetailFoodFragmentToCookFragment(
                food
            )
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}