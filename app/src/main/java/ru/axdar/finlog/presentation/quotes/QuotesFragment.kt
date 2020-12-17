package ru.axdar.finlog.presentation.quotes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import ru.axdar.finlog.R
import ru.axdar.finlog.databinding.FragmentQuotesBinding
import javax.inject.Inject

class QuotesFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<QuotesViewModel> { viewModelFactory }
    private lateinit var binding: FragmentQuotesBinding
    @Inject lateinit var adapter: QuoteDataAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

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