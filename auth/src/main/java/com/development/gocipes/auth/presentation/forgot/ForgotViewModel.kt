package com.development.gocipes.auth.presentation.forgot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.development.gocipes.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    fun forgotPassword(email: String) = authRepository.forgotPassword(email).asLiveData()
}