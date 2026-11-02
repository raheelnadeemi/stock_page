package com.example.data.datasource

import com.example.data.model.ResearchCallDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface ResearchDataSource {
    fun getRawResearchCalls(): Flow<List<ResearchCallDto>>
}

class ResearchDataSourceImpl : ResearchDataSource {

    override fun getRawResearchCalls(): Flow<List<ResearchCallDto>> = flowOf(
        listOf(
            ResearchCallDto("1", "AAPL", "Goldman Sachs", "BUY", 210.0),
            ResearchCallDto("2", "NVDA", "Morgan Stanley", "OVERWEIGHT", 550.0),
            ResearchCallDto("3", "TSLA", "JPMorgan", "HOLD", 230.0),
        )
    )

}