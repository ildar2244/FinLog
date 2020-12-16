package ru.axdar.finlog.presentation.quotes.model

data class QuoteUI(
    val id: Int = 0,
    val nameShort: String = "",
    val nameFull: String = "",
    val datetime: String = "",
    val value: Float = 0f,
    val change: Float = 0f,
)