package com.example.data.repository

import com.example.data.datasource.MarketDataSource
import com.example.data.datasource.ResearchDataSource
import com.example.data.mapper.toDomainList
import com.example.domain.model.ResearchCall
import com.example.domain.model.Ticker
import com.example.domain.repository.MarketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MarketRepositoryImpl(
    val marketDataSource: MarketDataSource,
    val researchDataSource: ResearchDataSource
): MarketRepository {

    override fun streamLiveMarketData(): Flow<List<Ticker>> {
        return marketDataSource.streamRawMarketData().map { it.toDomainList() }
    }

    override suspend fun getStaticResearchCalls(): List<ResearchCall> {
        return researchDataSource.getRawResearchCalls().toDomainList()
    }
}