package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Ticker(
    val id: String,
    val name: String,
    val price: Double,
    val changePercent: Double,
    val isPriceUp: Boolean
)

@Serializable
data class ResearchCall(
    val id: String,
    val ticker: String,
    val firm: String,
    val rating: String,
    val targetPrice: Double
)