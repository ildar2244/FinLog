package ru.axdar.finlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.axdar.finlog.data.MarketQuotesRepositoryImpl
import ru.axdar.finlog.domain.model.QuoteData
import ru.axdar.finlog.presentation.QuotesViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(QuotesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        viewModel.quoteLiveData.observe(this) {
            Log.d("9999", "onResume: ${it.first().nameFull}")
        }
    }
}