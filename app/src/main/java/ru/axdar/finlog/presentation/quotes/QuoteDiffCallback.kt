package ru.axdar.finlog.presentation.quotes

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.axdar.finlog.domain.model.QuoteData

class QuoteDiffCallback : DiffUtil.ItemCallback<QuoteData>() {
    override fun areItemsTheSame(oldItem: QuoteData, newItem: QuoteData): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: QuoteData, newItem: QuoteData): Boolean {
        return oldItem == newItem
    }
}