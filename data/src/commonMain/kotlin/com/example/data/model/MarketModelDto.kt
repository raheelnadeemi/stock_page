package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TickerDto(
    val id: String,
    val name: String,
    val price: Double,
    val changePercent: Double,
    val isPriceUp: Boolean
)

@Serializable
data class ResearchCallDto(
    val id: String,
    val ticker: String,
    val firm: String,
    val rating: String,
    val targetPrice: Double
)