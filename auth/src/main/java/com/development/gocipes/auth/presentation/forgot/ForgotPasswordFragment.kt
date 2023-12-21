package com.development.gocipes.auth.presentation.forgot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.development.gocipes.auth.databinding.FragmentForgotPasswordBinding
import com.development.gocipes.core.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment() {

    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<ForgotViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding?.contentForgot?.apply {
            btnRegister.setOnClickListener {
                val email = tilEmail.editText?.text.toString().trim()

                forgotObserver(email)
            }
        }
    }

    private fun forgotObserver(
        email: String
    ) {
        viewModel.forgotPassword(email)
            .observe(viewLifecycleOwner) { result ->
                when (result) {
                    is Result.Error -> {
                        Toast.makeText(requireActivity(), result.message, Toast.LENGTH_SHORT).show()
                    }

                    is Result.Loading -> {}
                    is Result.Success -> {
                        navigateToLogin()
                        Toast.makeText(
                            requireActivity(),
                            "Reset Password Berhasil, Silahkan Periksa Email Anda",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
    }

    private fun navigateToLogin() {
        val action =
            ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}