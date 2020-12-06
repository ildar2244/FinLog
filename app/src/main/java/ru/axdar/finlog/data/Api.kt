package ru.axdar.finlog.data

import retrofit2.http.GET

/** Created on 06.12.2020. */
interface Api {
    @GET("/v1/cryptocurrency/listings/latest?limit=10")
    suspend fun getCryptoCurrency(): CoinMarketResponse
}