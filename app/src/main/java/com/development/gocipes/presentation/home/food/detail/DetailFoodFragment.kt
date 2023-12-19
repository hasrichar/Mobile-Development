package com.development.gocipes.presentation.home.food.detail

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
import com.development.gocipes.core.domain.model.food.Food
import com.development.gocipes.core.domain.model.food.Ingredient
import com.development.gocipes.core.presentation.adapter.IngredientAdapter
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.databinding.FragmentDetailFoodBinding
import com.development.gocipes.food.R
import com.development.gocipes.core.R as Resource

class DetailFoodFragment : Fragment() {

    private var _binding: FragmentDetailFoodBinding? = null
    private val binding get() = _binding
    private val navArgs by navArgs<DetailFoodFragmentArgs>()
    private var menuDetail: Menu? = null
    private var statusFavorite: Boolean = false
    private lateinit var ingredientAdapter: IngredientAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
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
        binding?.contentDetail?.apply {
            sivFood.showImage(requireActivity(), food.imageUrl)
            tvDescription.text = food.description
            tvMinutes.text = food.minutes
            contentCalories.apply {
                pbFat.progress = food.fat
                tvFat.text = "${food.fat}%"
                pbCarbohydrates.progress = food.carbohydrates
                tvCarbohydrates.text = "${food.carbohydrates}%"
                pbProtein.progress = food.protein
                tvProtein.text = "${food.protein}%"
            }
        }

        binding?.btnCook?.setOnClickListener { navigateToCook(food) }
    }

    private fun setupRecyclerIngredient(listIngredient: List<Ingredient>) {
        ingredientAdapter = IngredientAdapter()

        binding?.contentDetail?.rvIngredients?.apply {
            adapter = ingredientAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
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
                menuInflater.inflate(com.development.gocipes.R.menu.menu_detail, menu)
                menuDetail = menu
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    com.development.gocipes.R.id.btn_favorite -> {
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
        val menuItem = menuDetail?.findItem(com.development.gocipes.R.id.btn_favorite)
        if (favorite) {
            menuItem?.icon =
                ContextCompat.getDrawable(requireActivity(), Resource.drawable.ic_favorite)
        } else {
            menuItem?.icon =
                ContextCompat.getDrawable(requireActivity(), Resource.drawable.ic_favorite_border)
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