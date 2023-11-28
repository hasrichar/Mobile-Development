package com.development.gocipes.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.core.model.Food
import com.development.gocipes.core.presentation.adapter.CategoryAdapter
import com.development.gocipes.core.presentation.adapter.FoodAdapter
import com.development.gocipes.core.presentation.adapter.InformationAdapter
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var informationAdapter: InformationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listCategory = com.development.gocipes.core.data.DummyCategory.dummyCategory
        val listFood = com.development.gocipes.core.data.DummyFood.dummyFood
        val listGuide = com.development.gocipes.core.data.DummyInformation.dummyArticle
        val listTechnique = com.development.gocipes.core.data.DummyInformation.dummyTechnique

        val name = "Mutiara!"
        val url =
            "https://www.betterup.com/hubfs/Blog%20Images/authentic-self-person-smiling-at-camera.jpg"

        binding?.contentHome?.apply {
            sivProfile.showImage(requireActivity(), url)
            tvName.text = name
            searchBar.setOnClickListener { navigateToSearch() }
            tvAllFood.setOnClickListener { navigateToFood() }
            tvAllArticle.setOnClickListener { navigateToArticle() }
            tvAllTechnique.setOnClickListener { navigateToTechnique() }
        }

        setupRecyclerCategory(listCategory)
        setupRecyclerViewFood(listFood)
        setupRecyclerViewGuide(listGuide)
        setupRecyclerViewTechnique(listTechnique)
    }

    private fun setupRecyclerCategory(categories: List<com.development.gocipes.core.model.Category>) {
        categoryAdapter = CategoryAdapter { category ->
            navigateToCategory(category)
        }

        binding?.contentHome?.rvCategory?.apply {
            adapter = categoryAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        categoryAdapter.submitList(categories)
    }

    private fun setupRecyclerViewFood(listFood: List<Food>) {
        foodAdapter = FoodAdapter { food ->
            navigateToDetailFood(food)
        }

        binding?.contentHome?.rvFood?.apply {
            adapter = foodAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        foodAdapter.submitList(listFood)
    }

    private fun setupRecyclerViewGuide(listInformation: List<com.development.gocipes.core.model.Information>) {
        informationAdapter = InformationAdapter { information ->
            navigateDetailArticle(information)
        }

        binding?.contentHome?.rvGuide?.apply {
            adapter = informationAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        informationAdapter.submitList(listInformation)
    }

    private fun setupRecyclerViewTechnique(listTechnique: List<com.development.gocipes.core.model.Information>) {
        informationAdapter = InformationAdapter { information ->
            navigateToDetailTechnique(information)
        }

        binding?.contentHome?.rvTechnique?.apply {
            adapter = informationAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        informationAdapter.submitList(listTechnique)
    }

    private fun navigateToDetailFood(food: Food) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailFoodFragment(
                food
            )
        findNavController().navigate(action)
    }

    private fun navigateToFood() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToFoodFragment()
        findNavController().navigate(action)
    }

    private fun navigateToArticle() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToArticleFragment()
        findNavController().navigate(action)
    }

    private fun navigateDetailArticle(information: com.development.gocipes.core.model.Information) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailArticleFragment(
                information
            )
        findNavController().navigate(action)
    }

    private fun navigateToTechnique() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToTechniqueFragment()
        findNavController().navigate(action)
    }

    private fun navigateToDetailTechnique(information: com.development.gocipes.core.model.Information) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailTechniqueFragment(
                information
            )
        findNavController().navigate(action)
    }

    private fun navigateToSearch() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToSearchFragment()
        findNavController().navigate(action)
    }

    private fun navigateToCategory(category: com.development.gocipes.core.model.Category) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToCategoryFragment(
                category
            )
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}