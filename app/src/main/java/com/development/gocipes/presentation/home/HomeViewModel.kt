package com.development.gocipes.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.development.gocipes.core.domain.repository.AuthRepository
import com.development.gocipes.core.domain.repository.TechniqueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val techniqueRepository: TechniqueRepository
): ViewModel() {
    fun getUserInfo() = authRepository.getUserInfo().asLiveData()

    fun getAllTechnique() = techniqueRepository.getAllTechnique().asLiveData()
}