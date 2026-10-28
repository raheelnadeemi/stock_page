package com.example.axisassignment.di

import com.example.data.datasource.MarketDataSource
import com.example.data.datasource.MarketDataSourceImpl
import com.example.data.datasource.ResearchDataSource
import com.example.data.datasource.ResearchDataSourceImpl
import com.example.data.repository.MarketRepositoryImpl
import com.example.domain.repository.MarketRepository
import com.example.domain.usecase.MarketUseCase
import com.example.domain.usecase.ResearchUseCase
import com.example.presentation.viewmodel.MarketViewModel
import com.example.presentation.viewmodel.ResearchViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::MarketDataSourceImpl) {bind<MarketDataSource>()}
    singleOf(::ResearchDataSourceImpl) {bind<ResearchDataSource>()}
    singleOf(::MarketRepositoryImpl) {bind<MarketRepository>()}
}

val domainModule = module {
    singleOf(::MarketUseCase)
    singleOf(::ResearchUseCase)
}

val presentationModule = module{
    viewModelOf(::MarketViewModel)
    viewModelOf(::ResearchViewModel)
}

val appModule = module {
    includes(dataModule, domainModule, presentationModule)
}