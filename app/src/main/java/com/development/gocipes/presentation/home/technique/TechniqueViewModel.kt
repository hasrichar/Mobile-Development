package com.development.gocipes.presentation.home.technique

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.development.gocipes.core.domain.repository.TechniqueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TechniqueViewModel @Inject constructor(
    private val techniqueRepository: TechniqueRepository
) : ViewModel() {

    fun getAllTechnique() = techniqueRepository.getAllTechnique().asLiveData()
}