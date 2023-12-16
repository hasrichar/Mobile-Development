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
import com.development.gocipes.core.data.local.prefs.Prefs
import com.development.gocipes.core.data.remote.response.auth.UserResult
import com.development.gocipes.core.domain.model.food.Category
import com.development.gocipes.core.domain.model.food.Food
import com.development.gocipes.core.domain.model.information.Information
import com.development.gocipes.core.domain.model.technique.Technique
import com.development.gocipes.core.presentation.adapter.CategoryAdapter
import com.development.gocipes.core.presentation.adapter.FoodAdapter
import com.development.gocipes.core.presentation.adapter.InformationAdapter
import com.development.gocipes.core.presentation.adapter.TechniqueAdapter
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.core.utils.Result
import com.development.gocipes.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var informationAdapter: InformationAdapter
    private val techniqueAdapter by lazy { TechniqueAdapter() }
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listCategory = DummyCategory.dummyCategory
        val listFood = DummyFood.dummyFood
        val listGuide = DummyInformation.dummyArticle

        userInfoObserver()
        techniqueObserver()

        setupRecyclerCategory(listCategory)
        setupRecyclerViewFood(listFood)
        setupRecyclerViewGuide(listGuide)
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
                    Prefs.firstName = user.firstName
                    setupView(user)
                }
            }
        }
    }

    private fun techniqueObserver() {
        viewModel.getAllTechnique().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                }
                is Result.Loading -> {}
                is Result.Success -> {
                    setupRecyclerViewTechnique(result.data)
                }
            }
        }
    }

    private fun setupView(userResult: UserResult) {
        val fullName = userResult.firstName + userResult.lastName

        binding?.contentHome?.apply {
            sivProfile.showImage(requireActivity(), userResult.photo)
            tvName.text = fullName
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

    private fun setupRecyclerViewGuide(listInformation: List<Information>) {
        informationAdapter = InformationAdapter { information ->
            navigateToArticleGraph(information)
        }

        binding?.contentHome?.rvGuide?.apply {
            adapter = informationAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        informationAdapter.submitList(listInformation)
    }

    private fun setupRecyclerViewTechnique(listTechnique: List<Technique>) {

        binding?.contentHome?.rvTechnique?.apply {
            adapter = techniqueAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        techniqueAdapter.submitList(listTechnique)
    }

    private fun navigateToFood() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToFoodFragment()
        findNavController().navigate(action)
    }

    private fun navigateToFoodGraph(food: Food) {
        val action = HomeFragmentDirections.actionHomeFragmentToFoodGraph(food)
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