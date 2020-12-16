package ru.axdar.finlog.presentation.quotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.axdar.finlog.R
import ru.axdar.finlog.data.MarketQuotesRepositoryImpl
import ru.axdar.finlog.databinding.FragmentQuotesBinding
import ru.axdar.finlog.domain.QuotesUseCase

class QuotesFragment : Fragment() {

    private lateinit var binding: FragmentQuotesBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(QuotesViewModel::class.java)
    }

    private lateinit var adapter: QuoteDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quotes, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        adapter = QuoteDataAdapter()
        binding.rvQuotes.adapter = adapter

        return binding.root
    }

    companion object {
        private var INSTANCE: QuotesFragment? = null
        fun getInstance(): QuotesFragment {
            if (INSTANCE == null) {
                INSTANCE = QuotesFragment()
            } else {
                INSTANCE
            }
            return INSTANCE as QuotesFragment
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.apply {

            loading.observe(viewLifecycleOwner) { isShow ->
                //pb_images.visibility = if (isShow) View.VISIBLE else View.GONE
            }

            error.observe(viewLifecycleOwner) { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }

            quoteLiveData.observe(viewLifecycleOwner) {
                it?.let {
                    adapter.submitList(it)
                }
            }
        }
    }
}