package ru.axdar.finlog.presentation.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.axdar.finlog.R

class TransactionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transactions, container, false)
    }

    companion object {
        private var INSTANCE: TransactionsFragment? = null
        fun getInstance(): TransactionsFragment {
            if (INSTANCE == null) {
                INSTANCE = TransactionsFragment()
            } else {
                INSTANCE
            }
            return INSTANCE as TransactionsFragment
        }
    }
}