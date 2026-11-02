package com.example.presentation.viewmodel

import com.example.domain.model.ResearchCall
import com.example.domain.model.Ticker
import com.example.domain.repository.MarketRepository
import com.example.domain.usecase.MarketUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MarketViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun market_emitsTickersFromUseCase() = runTest {
        val expectedTickers = listOf(
            Ticker("1", "AAPL", 175.0, 0.5, true),
            Ticker("2", "TSLA", 240.0, -0.2, false)
        )

        val fakeRepository = object : MarketRepository {
            override fun streamLiveMarketData(): Flow<List<Ticker>> = flowOf(expectedTickers)
            override fun getStaticResearchCalls(): Flow<List<ResearchCall>> = flowOf(emptyList())
        }
        val useCase = MarketUseCase(fakeRepository)
        val viewModel = MarketViewModel(useCase)

        val collectedValues = mutableListOf<List<Ticker>>()
        val job = launch(testDispatcher) {
            viewModel.market.collect { collectedValues.add(it) }
        }

        assertEquals(expectedTickers, viewModel.market.value)

        job.cancel()
    }
}
