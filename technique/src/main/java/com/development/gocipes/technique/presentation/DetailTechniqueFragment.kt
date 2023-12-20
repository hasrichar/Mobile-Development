package com.development.gocipes.technique.presentation

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
import com.development.gocipes.core.domain.model.information.Information
import com.development.gocipes.technique.databinding.FragmentDetailTechniqueBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class DetailTechniqueFragment : Fragment() {

    private var _binding: FragmentDetailTechniqueBinding? = null
    private val binding get() = _binding
    private val navArgs by navArgs<DetailTechniqueFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailTechniqueBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        val techniqueArgs = navArgs.information

        binding?.contentDetailTechnique?.apply {
            tvTitle.text = techniqueArgs.name
            techniqueArgs.listPractice?.forEach { tvPractice.append("• $it \n") }
        }

        setupToolbar()
        setUpYoutubeApi(techniqueArgs)
        setupShimmer()
    }

    private fun setupShimmer() {
        binding?.apply {
            contentDetailTechnique.root.visibility = View.INVISIBLE
            toolbar.visibility = View.INVISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                contentDetailTechnique.root.visibility = View.VISIBLE
                toolbar.visibility = View.VISIBLE

                shimmer.apply {
                    stopShimmer()
                    visibility = View.INVISIBLE
                }
            }, 2000)
        }
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowTitleEnabled(false)
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

    private fun setUpYoutubeApi(information: Information) {
        binding?.contentDetailTechnique?.apply {
            lifecycle.addObserver(ytPlayer)
            ytPlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = information.videoUrl
                    if (videoId != null) {
                        youTubePlayer.loadVideo(videoId, 0f)
                    }
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}