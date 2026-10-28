package com.example.axisassignment

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.screen.LiveMarketScreen
import com.example.presentation.viewmodel.MarketViewModel
import com.example.presentation.viewmodel.ResearchViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {

    val marketViewModel: MarketViewModel = koinViewModel()
    val researchViewModel: ResearchViewModel = koinViewModel()
    LiveMarketScreen(marketViewModel, researchViewModel)

}