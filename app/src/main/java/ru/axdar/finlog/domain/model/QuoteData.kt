package ru.axdar.finlog.domain.model

data class QuoteData(
    val id: Int = 0,
    val nameShort: String = "",
    val nameFull: String = "",
    val datetime: String = "",
    val value: Float = 0f,
    val change: Float = 0f,
)