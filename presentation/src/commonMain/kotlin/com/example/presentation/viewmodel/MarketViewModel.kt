package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Ticker
import com.example.domain.usecase.MarketUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MarketViewModel(val marketUseCase: MarketUseCase) : ViewModel() {

    private val _market = MutableStateFlow<List<Ticker>>(emptyList())
    val market: StateFlow<List<Ticker>> = _market.asStateFlow()

    init {
        startStreaming()
    }

    private fun startStreaming() {
        viewModelScope.launch {
            marketUseCase.streamLiveMarketData()
                .onEach { _market.value = it}
                .launchIn(viewModelScope)
            }
        }

}
