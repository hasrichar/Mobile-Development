package com.development.gocipes.presentation.chatbot

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.development.gocipes.databinding.FragmentChatBotBinding

class ChatBotFragment : Fragment() {

    private var _binding: FragmentChatBotBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentChatBotBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.webView?.apply {
            loadUrl("https://becipes.github.io/HCAI-Development/")
            settings.javaScriptEnabled = true
        }
        setupShimmer()
    }

    private fun setupShimmer() {
        binding?.apply {
            webView.visibility = View.INVISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                webView.visibility = View.VISIBLE
                shimmer.apply {
                    stopShimmer()
                    visibility = View.INVISIBLE
                }
            }, 3000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}