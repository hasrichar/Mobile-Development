package com.development.gocipes.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.core.data.local.dummy.DummyCategory
import com.development.gocipes.core.data.local.dummy.DummyFood
import com.development.gocipes.core.data.local.dummy.DummyInformation
import com.development.gocipes.core.data.remote.response.auth.UserResult
import com.development.gocipes.core.domain.model.article.Article
import com.development.gocipes.core.domain.model.food.Category
import com.development.gocipes.core.domain.model.food.Food
import com.development.gocipes.core.domain.model.information.Information
import com.development.gocipes.core.domain.model.technique.Technique
import com.development.gocipes.core.presentation.adapter.ArticleAdapter
import com.development.gocipes.core.presentation.adapter.CategoryAdapter
import com.development.gocipes.core.presentation.adapter.FoodAdapter
import com.development.gocipes.core.presentation.adapter.InformationAdapter
import com.development.gocipes.core.presentation.adapter.TechniqueAdapter
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.core.utils.Result
import com.development.gocipes.databinding.FragmentHomeBinding
import com.development.gocipes.presentation.home.article.ArticleViewModel
import com.development.gocipes.presentation.home.technique.TechniqueViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var informationAdapter: InformationAdapter
    private val viewModel by viewModels<HomeViewModel>()
    private val techniqueViewModel by viewModels<TechniqueViewModel>()
    private val articleViewModel by viewModels<ArticleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listCategory = DummyCategory.dummyCategory
        val listFood = DummyFood.dummyFood
        val listArticle = DummyInformation.dummyArticle
        val listTechnique = DummyInformation.dummyTechnique

        userInfoObserver()

        setupRecyclerCategory(listCategory)
        setupRecyclerViewFood(listFood)
        setupRecyclerViewTechnique(listTechnique)
        setupRecyclerViewGuide(listArticle)
    }

    private fun articleObserver() {
        articleViewModel.getAllArticle().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                }

                is Result.Loading -> {}
                is Result.Success -> {
                    result.data
                }
            }
        }
    }

    private fun userInfoObserver() {
        viewModel.getUserInfo().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    Toast.makeText(requireActivity(), result.message, Toast.LENGTH_SHORT).show()
                }

                is Result.Loading -> {}
                is Result.Success -> {
                    val user = result.data
                    setupView(user)
                }
            }
        }
    }

    private fun techniqueObserver() {
        techniqueViewModel.getAllTechnique().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                }

                is Result.Loading -> {}
                is Result.Success -> {
                    result.data
                }
            }
        }
    }

    private fun setupView(userResult: UserResult) {
        val urlPhoto =
            "https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg"

        binding?.contentHome?.apply {
            tvName.text = userResult.firstName
            sivProfile.showImage(requireActivity(), userResult.photo ?: urlPhoto)
            searchBar.setOnClickListener { navigateToSearch() }
            tvAllFood.setOnClickListener { navigateToFood() }
            tvAllArticle.setOnClickListener { navigateToArticle() }
            tvAllTechnique.setOnClickListener { navigateToTechnique() }
        }
    }

    private fun setupRecyclerCategory(categories: List<Category>) {
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
            navigateToFoodGraph(food)
        }

        binding?.contentHome?.rvFood?.apply {
            adapter = foodAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        foodAdapter.submitList(listFood)
    }

    private fun setupRecyclerViewGuide(listArtikel: List<Information>) {
        informationAdapter = InformationAdapter { article ->
            navigateToArticleGraph(article)
        }

        binding?.contentHome?.rvGuide?.apply {
            adapter = informationAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        informationAdapter.submitList(listArtikel)
    }

    private fun setupRecyclerViewTechnique(listTechnique: List<Information>) {
        informationAdapter = InformationAdapter { technique ->
            navigateToTechniqueGraph(technique)
        }
        binding?.contentHome?.rvTechnique?.apply {
            adapter = informationAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        informationAdapter.submitList(listTechnique)
    }

    private fun navigateToFood() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToFoodFragment()
        findNavController().navigate(action)
    }

    private fun navigateToFoodGraph(food: Food) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFoodFragment(food)
        findNavController().navigate(action)
    }

    private fun navigateToArticle() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToArticleFragment()
        findNavController().navigate(action)
    }

    private fun navigateToArticleGraph(information: Information) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToArticleGraph(information)
        findNavController().navigate(action)
    }

    private fun navigateToTechnique() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToTechniqueFragment()
        findNavController().navigate(action)
    }

    private fun navigateToTechniqueGraph(information: Information) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToTechniqueGraph(information)
        findNavController().navigate(action)
    }

    private fun navigateToSearch() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToSearchFragment()
        findNavController().navigate(action)
    }

    private fun navigateToCategory(category: Category) {
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