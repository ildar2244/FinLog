package ru.axdar.finlog.presentation.quotes

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.axdar.finlog.presentation.quotes.model.QuoteUI

class QuoteDiffCallback : DiffUtil.ItemCallback<QuoteUI>() {
    override fun areItemsTheSame(oldItem: QuoteUI, newItem: QuoteUI): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: QuoteUI, newItem: QuoteUI): Boolean {
        return oldItem == newItem
    }
}