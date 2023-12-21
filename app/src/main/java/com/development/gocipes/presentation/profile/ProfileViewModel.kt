package com.development.gocipes.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.development.gocipes.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    fun getCurrentUser() = authRepository.getUserInfo().asLiveData()
    suspend fun logout() = authRepository.deleteToken()
}