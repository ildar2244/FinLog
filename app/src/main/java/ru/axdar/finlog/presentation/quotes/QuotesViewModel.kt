package ru.axdar.finlog.presentation.quotes

import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.axdar.finlog.core.Response
import ru.axdar.finlog.data.MarketQuotesRepositoryImpl
import ru.axdar.finlog.domain.QuotesUseCase
import ru.axdar.finlog.domain.model.QuoteData
import ru.axdar.finlog.presentation.quotes.model.QuoteUI

class QuotesViewModel(
    //private val useCase: QuotesUseCase
) : ViewModel(), LifecycleObserver {

    val useCase: QuotesUseCase = QuotesUseCase(MarketQuotesRepositoryImpl())

    private val _loading = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<String>()
    private val _quotesData = MutableLiveData<List<QuoteUI>>()

    val loading: LiveData<Boolean> = _loading
    val error: LiveData<String> = _error
    val quoteLiveData: LiveData<List<QuoteUI>> = _quotesData

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        getQuotesData()
    }

    private fun getQuotesData() {
        useCase(Unit) { response ->
            when (response) {
                is Response.Loading -> _loading.value = true
                is Response.Success -> {
                    _loading.value = false
                    _quotesData.value = response.value.map { it.toQuoteUI() }
                }
                is Response.Error -> {
                    _loading.value = false
                    _error.value = "Ошибка ${response.exception.message}"
                }
            }
        }
    }

    private fun QuoteData.toQuoteUI() = QuoteUI(id, nameShort, nameFull, datetime, value, change)
}