package com.development.gocipes.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.development.gocipes.core.data.local.prefs.Prefs
import com.development.gocipes.core.utils.Extensions.showImage
import com.development.gocipes.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
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

    private fun setupView() {
        binding?.apply {
            ivProfileFotoProfil.showImage(
                requireActivity(),
                "https://www.betterup.com/hubfs/Blog%20Images/authentic-self-person-smiling-at-camera.jpg"
            )
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

        Prefs.logout
        val action = ProfileFragmentDirections.actionProfileFragmentToAuthGraph()
        findNavController().navigate(action)
    }
}