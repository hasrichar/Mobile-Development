package com.development.gocipes.food.presentation.timer

import android.annotation.SuppressLint
import android.os.Bundle
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
import androidx.viewpager.widget.ViewPager
import com.development.gocipes.core.R
import com.development.gocipes.core.domain.model.food.Cook
import com.development.gocipes.core.domain.model.food.Food
import com.development.gocipes.core.presentation.adapter.TimerAdapter
import com.development.gocipes.food.databinding.FragmentTimerBinding
import com.orbitalsonic.sonictimer.SonicCountDownTimer
import java.text.DecimalFormat
import kotlin.math.roundToInt

class TimerFragment : Fragment() {

    private var _binding: FragmentTimerBinding? = null
    private val binding get() = _binding
    private lateinit var countDownTimer: SonicCountDownTimer
    private lateinit var timerAdapter: TimerAdapter
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
            btnNext.setOnClickListener { next() }
            btnPrevious.setOnClickListener { previous() }
        }

        setupTimer(foodArgs.step[0].minutes)
        setupToolbar(foodArgs.step[0].id)
        setupViewPager(step)
        pageChange(foodArgs)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupViewPager(steps: List<Cook>) {
        timerAdapter = TimerAdapter(requireActivity(), steps)

        binding?.viewPager?.apply {
            adapter = timerAdapter
        }

        binding?.viewPager?.setOnTouchListener { _, _ -> true }
    }

    private fun setupToolbar(id: Int) {
        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding?.toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                title = "Step $id"
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

    private fun pageChange(food: Food) {
        binding?.viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                setupTimer(food.step[position].minutes)
                setupToolbar(food.step[position].id)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setupTimer(timer: Int) {
        val clockTime = (timer * 60 * 1000).toLong()
        val progressTime = (clockTime / 1000).toFloat()
        val second = (clockTime / 1000.0f).roundToInt()

        var secondLeft = 0
        countDownTimer = object : SonicCountDownTimer(clockTime, 1000) {
            override fun onTimerTick(timeRemaining: Long) {
                val seconds = (timeRemaining / 1000.0f).roundToInt()
                if (seconds != secondLeft) {
                    secondLeft = seconds
                    binding?.apply {
                        timerFormat(secondLeft, tvTimer)
                    }
                }
            }

            override fun onTimerFinish() {
                binding?.apply {
                    binding?.apply {
                        viewPager.setCurrentItem(viewPager.currentItem + 1, true)
                        countDownTimer.startCountDownTimer()
                    }
                }
            }
        }

        binding?.apply {
            btnPause.setOnClickListener {
                if (countDownTimer.isTimerRunning()) {
                    if (countDownTimer.isTimerPaused()) {
                        countDownTimer.resumeCountDownTimer()
                        btnPause.icon =
                            ContextCompat.getDrawable(
                                requireActivity(),
                                R.drawable.ic_pause
                            )
                    } else {
                        countDownTimer.pauseCountDownTimer()
                        btnPause.icon =
                            ContextCompat.getDrawable(requireActivity(), R.drawable.ic_play)
                    }
                } else {
                    countDownTimer.startCountDownTimer()
                    btnPause.icon =
                        ContextCompat.getDrawable(requireActivity(), R.drawable.ic_pause)
                }
            }
            btnNext.setOnClickListener {
                countDownTimer.cancelCountDownTimer()
                btnPause.icon =
                    ContextCompat.getDrawable(requireActivity(), R.drawable.ic_play)
                next()
            }
            btnPrevious.setOnClickListener {
                countDownTimer.cancelCountDownTimer()
                btnPause.icon =
                    ContextCompat.getDrawable(requireActivity(), R.drawable.ic_play)
                previous()
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

    private fun previous() {
        binding?.apply {
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)
        }
    }

    private fun next() {
        binding?.apply {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        countDownTimer.cancelCountDownTimer()
    }
}