package ru.axdar.finlog.data.model

import com.google.gson.annotations.SerializedName

/** Created on 06.12.2020. */

data class CoinMarketResponse(
    @SerializedName("data")
    val coins: List<Coin> = listOf()
) {

    data class Coin(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("name")
        val name: String,
        @SerializedName("symbol")
        val symbol: String,
        @SerializedName("last_updated")
        val last_updated: String,
        @SerializedName("quote")
        val quote: Quote,
    )

    data class Quote(
        @SerializedName("USD")
        val inUSD: USD
    )

    data class USD(
        @SerializedName("price")
        val price: Float = 0.0f,
        @SerializedName("percent_change_24h")
        val percent_change_24h: Float = 0.0f
    )
}
