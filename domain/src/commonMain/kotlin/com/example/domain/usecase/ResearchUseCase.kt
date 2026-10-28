package com.example.domain.usecase

import com.example.domain.repository.MarketRepository

class ResearchUseCase(val repository: MarketRepository) {
    suspend fun getStaticResearchCalls() = repository.getStaticResearchCalls()
}