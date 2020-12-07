package ru.axdar.finlog.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.axdar.finlog.domain.IMarketQuotesRepository
import ru.axdar.finlog.domain.model.QuoteData

class MarketQuotesRepositoryImpl : IMarketQuotesRepository {

    private val client: Api = ApiClient().makeService()

    override suspend fun getMarketQuotes(): Flow<List<QuoteData>> = flow {
        val coinMarketResponse: List<Coin> = client.getCryptoCurrency().coins
        Log.d("9999", "getMarketQuotes: $coinMarketResponse")
        val quotes = mutableListOf<QuoteData>()
        coinMarketResponse.map {
            quotes.add(it.toQuote())
        }
        quotes.toList()
        emit(quotes)
    }

    private fun Coin.toQuote() = QuoteData(
        id = id,
        nameShort = symbol,
        nameFull = name,
        datetime = last_updated,
        value = quote.inUSD.price,
        change = quote.inUSD.percent_change_24h
    )
}