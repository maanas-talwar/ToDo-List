package com.example.todozzz.ui.weeklyList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todozzz.R

class WeeklyListFragment : Fragment() {

    private lateinit var weeklyListViewModel: WeeklyListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        weeklyListViewModel =
                ViewModelProviders.of(this).get(WeeklyListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_weekly_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_weekly_list)
        weeklyListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
