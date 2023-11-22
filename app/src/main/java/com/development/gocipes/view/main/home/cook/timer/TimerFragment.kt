package com.development.gocipes.view.main.home.cook.timer

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.development.gocipes.R
import com.development.gocipes.databinding.FragmentTimerBinding
import com.development.gocipes.model.Food
import com.development.gocipes.utils.Extensions.showImage
import java.text.DecimalFormat
import kotlin.math.roundToInt

class TimerFragment : Fragment() {

    private var _binding: FragmentTimerBinding? = null
    private val binding get() = _binding
    private lateinit var countDownTimer: CountDownTimer
    private val navArgs by navArgs<TimerFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimerBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        val foodArgs = navArgs.food
        val step = foodArgs.step

        binding?.apply {
            sivStep.showImage(requireActivity(), step[0].imageUrl)
            tvStep.text = step[0].description
        }

        setupToolbar(foodArgs)
        setupTimer(step[0].minutes)
    }

    private fun setupToolbar(food: Food) {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = "Step ${food.step[0].id}"
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

    private fun setupTimer(timer: Int) {
        val clockTime = (timer * 60 * 1000).toLong()
        val progressTime = (clockTime / 1000).toFloat()
        val second = (clockTime / 1000.0f).roundToInt()

        var secondLeft = 0
        countDownTimer = object : CountDownTimer(clockTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val second = (millisUntilFinished / 1000.0f).roundToInt()
                if (second != secondLeft) {
                    secondLeft = second

                    binding?.apply {
                        timerFormat(secondLeft, tvTimer)
                        btnPause.setOnClickListener {
                            countDownTimer.cancel()
                            btnPause.icon = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_play)
                        }
                    }
                }
            }

            override fun onFinish() {
                binding?.tvTimer?.let { timerFormat(0, it) }
            }
        }

        binding?.apply {
            btnPause.setOnClickListener {
                countDownTimer.start()
                btnPause.icon = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_pause)
            }
            timerFormat(second, tvTimer)
            progressCircular.max = progressTime.toInt()
            progressCircular.progress = progressTime.toInt()
        }
    }

    private fun timerFormat(secondsLeft: Int, timeTxt: TextView) {
        binding?.progressCircular?.progress = secondsLeft
        val decimalFormat = DecimalFormat("00")
        val min = (secondsLeft % 3600) / 60
        val seconds = secondsLeft % 60

        val timeFormat = decimalFormat.format(min) + ":" + decimalFormat.format(seconds)

        timeTxt.text = timeFormat
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}