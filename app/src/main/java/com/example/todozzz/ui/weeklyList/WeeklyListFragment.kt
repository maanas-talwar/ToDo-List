package com.example.todozzz.ui.weeklyList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todozzz.R
import com.example.todozzz.databinding.FragmentWeeklyListBinding

class WeeklyListFragment : Fragment() {

    private lateinit var binding: FragmentWeeklyListBinding

    private lateinit var weeklyListViewModel: WeeklyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        weeklyListViewModel =
                ViewModelProviders.of(this).get(WeeklyListViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weekly_list, container, false)
        weeklyListViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textWeeklyList.text = it
        })
        return binding.root
    }
}
