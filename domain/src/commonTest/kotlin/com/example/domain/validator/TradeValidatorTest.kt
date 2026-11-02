package com.example.domain.validator

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TradeValidatorTest {

    private val validator = TradeValidator()

    @Test
    fun validTrade_returnsTrue() {
        val result = validator.validateTrade(ticker = "AAPL", quantity = 10, price = 175.50)
        assertTrue(result)
    }

    @Test
    fun blankTicker_returnsFalse() {
        val result = validator.validateTrade(ticker = "  ", quantity = 10, price = 175.50)
        assertFalse(result)
    }

    @Test
    fun zeroQuantity_returnsFalse() {
        val result = validator.validateTrade(ticker = "AAPL", quantity = 0, price = 175.50)
        assertFalse(result)
    }

    @Test
    fun negativeQuantity_returnsFalse() {
        val result = validator.validateTrade(ticker = "AAPL", quantity = -5, price = 175.50)
        assertFalse(result)
    }

    @Test
    fun quantityExceedsMaximum_returnsFalse() {
        val result = validator.validateTrade(ticker = "AAPL", quantity = 1_000_001, price = 175.50)
        assertFalse(result)
    }

    @Test
    fun zeroPrice_returnsFalse() {
        val result = validator.validateTrade(ticker = "AAPL", quantity = 10, price = 0.0)
        assertFalse(result)
    }

    @Test
    fun negativePrice_returnsFalse() {
        val result = validator.validateTrade(ticker = "AAPL", quantity = 10, price = -10.0)
        assertFalse(result)
    }
}
