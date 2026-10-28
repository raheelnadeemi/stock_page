package com.example.data.datasource

import com.example.data.model.ResearchCallDto


interface ResearchDataSource {
    suspend fun getRawResearchCalls(): List<ResearchCallDto>
}

class ResearchDataSourceImpl: ResearchDataSource {
    override suspend fun getRawResearchCalls(): List<ResearchCallDto> {
        return listOf(
            ResearchCallDto("1", "AAPL", "Goldman Sachs", "BUY", 210.0),
            ResearchCallDto("2", "NVDA", "Morgan Stanley", "OVERWEIGHT", 550.0),
            ResearchCallDto("3", "TSLA", "JPMorgan", "HOLD", 230.0)
        )
    }
}