package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ResearchCall
import com.example.domain.usecase.ResearchUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ResearchViewModel(researchUseCase: ResearchUseCase) : ViewModel() {

    val research: StateFlow<List<ResearchCall>> = researchUseCase.getStaticResearchCalls()
    .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList(),
    )
}