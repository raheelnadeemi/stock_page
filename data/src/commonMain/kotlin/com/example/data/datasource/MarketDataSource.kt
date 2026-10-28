package com.example.data.datasource

import com.example.data.model.TickerDto
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

interface MarketDataSource {
    fun streamRawMarketData(): Flow<List<TickerDto>>
}

class MarketDataSourceImpl : MarketDataSource {
    override fun streamRawMarketData(): Flow<List<TickerDto>> = flow {
        var statefulTickers = listOf(
            TickerDto("1", "AAPL", 175.0, 0.0, true),
            TickerDto("2", "TSLA", 240.0, 0.0, true),
            TickerDto("3", "NVDA", 480.0, 0.0, true)
        )
        while (true) {
            emit(statefulTickers)
            delay(100.milliseconds) // 10Hz high frequency updates
            statefulTickers = statefulTickers.map { ticker ->
                if (Random.nextBoolean()) {
                    val change = ticker.price * Random.nextDouble(-0.004, 0.004)
                    ticker.copy(
                        price = ticker.price + change,
                        changePercent = (change / ticker.price) * 100,
                        isPriceUp = change >= 0
                    )
                } else ticker
            }
        }
    }
}