package com.example.todozzz.ui.mostImpList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todozzz.R
import com.example.todozzz.databinding.FragmentMostImpListBinding
import com.example.todozzz.ui.mostImpList.MostImpListEntityAdapter
import com.example.todozzz.ui.mostImpList.MostImpListViewModel
import com.example.todozzz.ui.mostImpList.MostImpListViewModelFactory
import com.example.todozzz.ui.mostImpList.database.TasksDatabase

class MostImpListFragment : Fragment() {

    private lateinit var binding: FragmentMostImpListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_most_imp_list, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = TasksDatabase.getInstance(application).mostImpListDao

        val viewModelFactory = MostImpListViewModelFactory(dataSource, application)

        val mostImpListViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(MostImpListViewModel::class.java)

        val adapter = MostImpListEntityAdapter()
        binding.tasksList.adapter = adapter

        mostImpListViewModel.allTasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.addTaskButton.setOnClickListener() {onPressingDone()}

        binding.clearButton.setOnClickListener() {onPressingClear()}

        binding.setLifecycleOwner(this)

        binding.mostImpListViewModel = mostImpListViewModel

        return binding.root
    }
    fun onPressingDone() {
        val task: String = binding.taskName.text.toString()
        binding.taskName.getText().clear();
        binding.mostImpListViewModel?.addTask(task)
    }
    fun onPressingClear() {
        binding.mostImpListViewModel?.clearTasks()
    }
}
