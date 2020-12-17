package ru.axdar.finlog.di.module

import dagger.Binds
import dagger.Module
import ru.axdar.finlog.data.MarketQuotesRepositoryImpl
import ru.axdar.finlog.domain.IMarketQuotesRepository

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindQuotesRepository(repo: MarketQuotesRepositoryImpl): IMarketQuotesRepository
}