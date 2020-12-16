package ru.axdar.finlog.presentation.planner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.axdar.finlog.R

class PlannerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planner, container, false)
    }

    companion object {
        private var INSTANCE: PlannerFragment? = null
        fun getInstance(): PlannerFragment {
            if (INSTANCE == null) {
                INSTANCE = PlannerFragment()
            } else {
                INSTANCE
            }
            return INSTANCE as PlannerFragment
        }
    }
}