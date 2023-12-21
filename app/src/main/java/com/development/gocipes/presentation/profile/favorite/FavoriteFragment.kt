package com.development.gocipes.presentation.profile.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.gocipes.core.data.local.dummy.DummyFavorite
import com.development.gocipes.core.domain.model.favorite.Favorite
import com.development.gocipes.databinding.FragmentFavoriteBinding
import com.development.gocipes.core.presentation.adapter.FavoriteAdapter

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

        binding?.rvFavorite?.apply {
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