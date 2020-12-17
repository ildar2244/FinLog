package ru.axdar.finlog.presentation.quotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.axdar.finlog.databinding.ItemQuoteDataBinding
import ru.axdar.finlog.presentation.quotes.model.QuoteUI

class QuoteDataItemViewHolder private constructor(private val binding: ItemQuoteDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): QuoteDataItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemQuoteDataBinding.inflate(layoutInflater, parent, false)
            return QuoteDataItemViewHolder(binding)
        }
    }

    fun bind(item: QuoteUI) {
        binding.quote = item
        binding.executePendingBindings()
    }
}