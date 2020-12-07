package ru.axdar.finlog.domain

import kotlinx.coroutines.flow.Flow
import ru.axdar.finlog.domain.model.QuoteData

interface IMarketQuotesRepository {

    suspend fun getMarketQuotes(): Flow<List<QuoteData>>
}