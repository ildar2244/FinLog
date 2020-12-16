package ru.axdar.finlog.domain

import ru.axdar.finlog.core.Response
import ru.axdar.finlog.core.UseCase
import ru.axdar.finlog.domain.model.QuoteData

class QuotesUseCase(
    private val repository: IMarketQuotesRepository
) : UseCase<List<QuoteData>, Unit>() {

    override suspend fun run(params: Unit): Response<List<QuoteData>> {
        return repository.getMarketQuotes()
    }
}