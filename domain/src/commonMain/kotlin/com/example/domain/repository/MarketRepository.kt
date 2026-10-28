package com.example.domain.repository

import com.example.domain.model.ResearchCall
import com.example.domain.model.Ticker
import kotlinx.coroutines.flow.Flow

interface MarketRepository {

    fun streamLiveMarketData(): Flow<List<Ticker>>
    suspend fun getStaticResearchCalls(): List<ResearchCall>

}
