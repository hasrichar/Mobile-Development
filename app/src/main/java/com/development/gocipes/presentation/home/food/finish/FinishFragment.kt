package com.development.gocipes.presentation.home.food.finish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.development.gocipes.R
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {

    private var _binding: FragmentFinishBinding? = null
    private val binding get() = _binding
    private val navArgs by navArgs<FinishFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFinishBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodArgs = navArgs.food

        binding?.apply {
            contentFinish.apply {
                sivFood.showImage(requireActivity(), foodArgs.imageUrl)
                tvName.text = "Selamat anda telah memasak ${foodArgs.name}"
            }
            btnTimer.text = foodArgs.minutes
            btnHome.setOnClickListener {
                val option = NavOptions.Builder()
                    .setPopUpTo(R.id.finishFragment, inclusive = true)
                    .build()
                findNavController().navigate(R.id.action_finishFragment_to_homeFragment2, null, option)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}