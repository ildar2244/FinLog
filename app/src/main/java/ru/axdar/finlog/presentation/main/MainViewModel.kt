package ru.axdar.finlog.presentation.main

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.axdar.finlog.R
import ru.axdar.finlog.presentation.planner.PlannerFragment
import ru.axdar.finlog.presentation.quotes.QuotesFragment
import ru.axdar.finlog.presentation.transactions.TransactionsFragment

class MainViewModel : ViewModel(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var _fragment = MutableLiveData<Fragment>()
    val fragment: LiveData<Fragment> = _fragment

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_quotes -> {
                _fragment.value = QuotesFragment.getInstance()
                true
            }
            R.id.menu_transactions -> {
                _fragment.value = TransactionsFragment.getInstance()
                true
            }
            R.id.menu_planner -> {
                _fragment.value = PlannerFragment.getInstance()
                true
            }
            else -> false
        }
    }
}