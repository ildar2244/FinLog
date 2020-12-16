package ru.axdar.finlog.domain

import ru.axdar.finlog.core.Response
import ru.axdar.finlog.domain.model.QuoteData

interface IMarketQuotesRepository {

    suspend fun getMarketQuotes(): Response<List<QuoteData>>
}