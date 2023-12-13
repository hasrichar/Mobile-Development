package com.development.gocipes.auth.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.development.gocipes.auth.databinding.FragmentLoginBinding
import com.development.gocipes.core.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding?.contentLogin?.apply {
            btnLogin.setOnClickListener {
                val email = tilEmail.editText?.text?.toString()?.trim()
                val password = tilPassword.editText?.text?.toString()?.trim()

                if (email != null && password != null) loginObserver(email, password)
            }
            btnRegister.setOnClickListener { navigateToRegister() }
            tvForgotPassword.setOnClickListener { navigateToForgot() }
        }
    }

    private fun loginObserver(email: String, password: String) {
        viewModel.login(email, password).observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    Toast.makeText(requireActivity(), result.message, Toast.LENGTH_SHORT).show()
                }
                is Result.Loading -> {
                    binding?.contentLogin?.apply {
                        btnLogin.text = ""
                        progressCircular.visibility = View.VISIBLE
                    }
                }
                is Result.Success -> {
                    navigateToMain()
                }
            }
        }
    }

    private fun navigateToRegister() {
        val action =
            LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    private fun navigateToMain() {
        val action =
            LoginFragmentDirections.actionLoginFragmentToMainActivity()
        findNavController().navigate(action)
    }

    private fun navigateToForgot() {
        val action =
            LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment()
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}