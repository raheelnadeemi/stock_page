package com.example.domain.usecase

import com.example.domain.repository.MarketRepository

class MarketUseCase(val marketRepository: MarketRepository) {

    fun streamLiveMarketData() = marketRepository.streamLiveMarketData()

}
