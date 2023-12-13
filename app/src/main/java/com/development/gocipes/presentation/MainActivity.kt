package com.development.gocipes.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.development.gocipes.R
import com.development.gocipes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener {_, navDestination, _ ->
            Handler(Looper.getMainLooper()).post {
                when (navDestination.id) {
                    R.id.homeFragment, R.id.analysisFragment, R.id.favoriteFragment, R.id.profileFragment -> {
                        binding.bottomNav.visibility = View.VISIBLE
                    } else -> {
                        binding.bottomNav.visibility = View.GONE
                    }
                }
            }
        }

        binding.bottomNav.setupWithNavController(navController)
    }
}