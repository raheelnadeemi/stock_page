package com.example.data.mapper

import com.example.data.model.ResearchCallDto
import com.example.data.model.TickerDto
import com.example.domain.model.ResearchCall
import com.example.domain.model.Ticker
import kotlin.jvm.JvmName

fun TickerDto.toDomain(): Ticker {
    return Ticker(
        id = this.id,
        name = this.name,
        price = this.price,
        changePercent = this.changePercent,
        isPriceUp = this.isPriceUp
    )
}

@JvmName("toTickerDomainList")
fun List<TickerDto>.toDomainList(): List<Ticker> {
    return this.map { it.toDomain() }
}

fun ResearchCallDto.toDomain(): ResearchCall {
    return ResearchCall(
        id = this.id,
        ticker = this.ticker,
        firm = this.firm,
        rating = this.rating,
        targetPrice = this.targetPrice
    )
}

@JvmName("toResearchDomainList")
fun List<ResearchCallDto>.toDomainList(): List<ResearchCall> {
    return this.map { it.toDomain() }
}
