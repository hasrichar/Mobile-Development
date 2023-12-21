package com.development.gocipes.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.development.gocipes.core.data.remote.response.auth.UserResult
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.core.utils.Result
import com.development.gocipes.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUserObserver()

        binding?.btnProfileEdit?.setOnClickListener {
            onClickEdit()
        }
        binding?.btnProfileSimpan?.setOnClickListener {
            onClickSave()
        }
        binding?.btnLogout?.setOnClickListener {
            logout()
        }
    }

    private fun getUserObserver() {
        viewModel.getCurrentUser().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Error -> {
                    Toast.makeText(requireActivity(), result.message, Toast.LENGTH_SHORT).show()
                }
                is Result.Loading -> {}
                is Result.Success -> {
                    setupView(result.data)
                }
            }
        }
    }

    private fun setupView(user: UserResult) {
        val urlPhoto =
            "https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg"
        val userName = "${user.firstName} ${user.lastName}"

        binding?.apply {
            ivProfileFotoProfil.showImage(
                requireActivity(), user.photo ?: urlPhoto
            )
            edtProfileEmailUser.setText(user.email)
            edtProfileUsernameUser.setText(userName)
            edtProfilePasswordUser.setText(userName)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onClickEdit() {
        binding?.apply {
            btnProfileEdit.visibility = View.GONE
            btnProfileSimpan.visibility = View.VISIBLE

            edtProfileEmailUser.isEnabled = true
            edtProfilePasswordUser.isEnabled = true
            edtProfileUsernameUser.isEnabled = true
        }
    }

    private fun onClickSave() {
        binding?.apply {
            btnProfileEdit.visibility = View.VISIBLE
            btnProfileSimpan.visibility = View.GONE

            edtProfileEmailUser.isEnabled = false
            edtProfilePasswordUser.isEnabled = false
            edtProfileUsernameUser.isEnabled = false
        }
    }

    private fun logout() {
//        val logoutDialog = AlertDialog.Builder(this)
//        with(logoutDialog) {
//            setTitle(resources.getString(R.string.keluar))
//            setMessage(resources.getString(R.string.log_desc))
//            setPositiveButton(resources.getString(R.string.yes)) { _, _ ->
//                viewModel.logout()
//                viewModel.rmvSession()
//                intent = Intent(this@ProfileFragment, LoginActivity::class.java)
//                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(intent)
//                finish()
//            }
//            setNegativeButton(resources.getString(R.string.no)) { dialog, _ -> dialog.cancel() }
//        }
//        val alertDialog = logoutDialog.create()
//        alertDialog.show()

        val action = ProfileFragmentDirections.actionProfileFragmentToAuthGraph()
        findNavController().navigate(action)
    }
}