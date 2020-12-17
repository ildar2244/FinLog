package ru.axdar.finlog.presentation.quotes

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.axdar.finlog.presentation.DiffUtilItemCallbackFactory
import ru.axdar.finlog.presentation.quotes.model.QuoteUI
import javax.inject.Inject

class QuoteDataAdapter @Inject constructor(
    diffUtilItemCallback: DiffUtilItemCallbackFactory
) : ListAdapter<QuoteUI, QuoteDataItemViewHolder>(diffUtilItemCallback.create()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteDataItemViewHolder {
        return QuoteDataItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: QuoteDataItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}