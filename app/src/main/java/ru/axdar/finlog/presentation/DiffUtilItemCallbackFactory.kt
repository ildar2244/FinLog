package ru.axdar.finlog.presentation

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DiffUtilItemCallbackFactory {

    fun <T> create(): DiffUtil.ItemCallback<T> {
        return object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
        }
    }
}