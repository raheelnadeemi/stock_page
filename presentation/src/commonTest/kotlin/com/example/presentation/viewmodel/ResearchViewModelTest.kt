package com.example.presentation.viewmodel

import com.example.domain.model.ResearchCall
import com.example.domain.model.Ticker
import com.example.domain.repository.MarketRepository
import com.example.domain.usecase.ResearchUseCase
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
class ResearchViewModelTest {

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
    fun research_emitsCallsFromUseCase() = runTest {
        val expectedCalls = listOf(
            ResearchCall("1", "AAPL", "Goldman Sachs", "BUY", 210.0),
            ResearchCall("2", "NVDA", "Morgan Stanley", "OVERWEIGHT", 550.0)
        )

        val fakeRepository = object : MarketRepository {
            override fun streamLiveMarketData(): Flow<List<Ticker>> = flowOf(emptyList())
            override fun getStaticResearchCalls(): Flow<List<ResearchCall>> = flowOf(expectedCalls)
        }
        val useCase = ResearchUseCase(fakeRepository)
        val viewModel = ResearchViewModel(useCase)

        val collectedValues = mutableListOf<List<ResearchCall>>()
        val job = launch(testDispatcher) {
            viewModel.research.collect { collectedValues.add(it) }
        }

        assertEquals(expectedCalls, viewModel.research.value)

        job.cancel()
    }
}
