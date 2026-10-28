package com.example.domain.validator

import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName(name = "TradeValidator", exact = true)
class TradeValidator {

    fun validateTrade(ticker: String, quantity: Int, price: Double): Boolean {
        if (ticker.isBlank()) return false
        if (quantity !in 1..1_000_000) return false
        if (price <= 0.0) return false
        return true
    }
}
