package ru.axdar.finlog.presentation

import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.axdar.finlog.data.MarketQuotesRepositoryImpl
import ru.axdar.finlog.domain.model.QuoteData

class QuotesViewModel : ViewModel() {

    private val repository= MarketQuotesRepositoryImpl()
    private val _quotesData = MutableLiveData<List<QuoteData>>()
    val quoteLiveData: LiveData<List<QuoteData>> = _quotesData

    init {
        getQuotesData()
    }

    private fun getQuotesData() {
        viewModelScope.launch {
            repository.getMarketQuotes().collect {
                _quotesData.value = it
            }
        }
    }
}