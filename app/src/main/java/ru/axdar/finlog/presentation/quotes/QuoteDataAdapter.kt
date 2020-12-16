package ru.axdar.finlog.presentation.quotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.axdar.finlog.databinding.ItemQuoteDataBinding
import ru.axdar.finlog.domain.model.QuoteData
import ru.axdar.finlog.presentation.quotes.model.QuoteUI

class QuoteDataAdapter : ListAdapter<QuoteUI, QuoteDataAdapter.ViewHolder>(QuoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ItemQuoteDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: QuoteUI) {
            binding.quote = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemQuoteDataBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}