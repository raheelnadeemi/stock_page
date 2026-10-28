package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ResearchCall
import com.example.domain.usecase.ResearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.emptyList
import kotlinx.coroutines.launch

class ResearchViewModel(val researchUseCase: ResearchUseCase): ViewModel() {


    private val _research = MutableStateFlow<List<ResearchCall>>(emptyList())
    val research: StateFlow<List<ResearchCall>> = _research.asStateFlow()

    init {
        loadResearchData()
    }

    private fun loadResearchData() {
        viewModelScope.launch {
            _research.value = researchUseCase.getStaticResearchCalls()
        }
    }

    /* Junior developer code for code review and it notes

    var researchCalls = mutableListOf<String>()

    fun fetchCalls() {
        GlobalScope.launch {
            val result = api.getCalls() // suspending function
            researchCalls = result
        }
    }

     */
}