package ru.axdar.finlog.presentation

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


@BindingAdapter("onNavigationItemSelected")
fun setOnNavigationItemSelected(
    view: BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener?
) {
    view.setOnNavigationItemSelectedListener(listener)
}

@BindingAdapter("selectedItemPosition")
fun setSelectedItemPosition(
    view: BottomNavigationView, position: Int
) {
    view.selectedItemId = position
}