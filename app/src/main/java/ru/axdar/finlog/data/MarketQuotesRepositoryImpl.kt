package ru.axdar.finlog.data

import ru.axdar.finlog.core.Response
import ru.axdar.finlog.data.api.Api
import ru.axdar.finlog.data.model.CoinMarketResponse
import ru.axdar.finlog.domain.IMarketQuotesRepository
import ru.axdar.finlog.domain.model.QuoteData
import javax.inject.Inject

class MarketQuotesRepositoryImpl @Inject constructor(
    private val client: Api
) : IMarketQuotesRepository {

    override suspend fun getMarketQuotes(): Response<List<QuoteData>> {
        Response.loading<List<QuoteData>>()
        return try {
            val result = client.getCryptoCurrency().coins
                .map { it.toQuoteData() }
            Response.success(result)
        } catch (e: Exception) {
            Response.error(e)
        }
    }

    private fun CoinMarketResponse.Coin.toQuoteData() = QuoteData(
        id = id,
        nameShort = symbol,
        nameFull = name,
        datetime = last_updated,
        value = quote.inUSD.price,
        change = quote.inUSD.percent_change_24h
    )
}