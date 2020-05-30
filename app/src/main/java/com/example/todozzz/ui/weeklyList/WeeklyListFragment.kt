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
import com.example.todozzz.ui.weeklyList.database.TasksDatabase

class WeeklyListFragment : Fragment() {

    private lateinit var binding: FragmentWeeklyListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weekly_list, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = TasksDatabase.getInstance(application).weeklyListDao

        val viewModelFactory = WeeklyListViewModelFactory(dataSource, application)

        val weeklyListViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(WeeklyListViewModel::class.java)

        val adapter = WeeklyListEntityAdapter()
        binding.tasksList.adapter = adapter

        weeklyListViewModel.allTasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.addTaskButton.setOnClickListener() {onPressingDone()}

        binding.clearButton.setOnClickListener() {onPressingClear()}

        binding.setLifecycleOwner(this)

        binding.weeklyListViewModel = weeklyListViewModel

        return binding.root
    }
    fun onPressingDone() {
        val task: String = binding.taskName.text.toString()
        binding.taskName.getText().clear();
        binding.weeklyListViewModel?.addTask(task)
    }
    fun onPressingClear() {
        binding.weeklyListViewModel?.clearTasks()
    }
}
