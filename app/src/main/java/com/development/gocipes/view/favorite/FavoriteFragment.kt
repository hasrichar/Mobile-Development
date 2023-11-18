package com.development.gocipes.view.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.data.DummyCategory
import com.development.gocipes.data.DummyFavorite
import com.development.gocipes.databinding.FragmentFavoriteBinding
import com.development.gocipes.model.Favorite
import com.development.gocipes.view.favorite.adapter.FavoriteAdapter
import com.development.gocipes.view.home.adapter.CategoryAdapter

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listFavorite = DummyFavorite.dummyFavorite
        setupRecyclerFavorite(listFavorite)
    }

    private fun setupRecyclerFavorite(favorite: List<Favorite>) {
        favoriteAdapter = FavoriteAdapter()

        binding?.contentFavorite?.rvFavorite?.apply {
            adapter = favoriteAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }

        favoriteAdapter.submitList(favorite)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}