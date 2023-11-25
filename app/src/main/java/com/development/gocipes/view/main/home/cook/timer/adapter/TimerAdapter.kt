package com.development.gocipes.view.main.home.cook.timer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.development.gocipes.databinding.ItemTimerBinding
import com.development.gocipes.model.Cook
import com.development.gocipes.utils.Extensions.showImage

class TimerAdapter(private val context: Context, private val steps: List<Cook>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemTimerBinding.inflate(LayoutInflater.from(context), container, false)
        binding.apply {
            sivStep.showImage(context, steps[position].imageUrl)
            tvStep.text = steps[position].description
        }
        container.addView(binding.root)

        return binding.root
    }

    override fun getCount() = steps.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}