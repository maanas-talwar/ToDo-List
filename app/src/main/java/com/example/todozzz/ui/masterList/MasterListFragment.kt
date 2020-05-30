package com.example.todozzz.ui.masterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todozzz.R
import com.example.todozzz.ui.masterList.database.TasksDatabase
import com.example.todozzz.databinding.FragmentMasterListBinding

class MasterListFragment : Fragment() {

    private lateinit var binding: FragmentMasterListBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_master_list, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = TasksDatabase.getInstance(application).masterListDao

        val viewModelFactory = MasterListViewModelFactory(dataSource, application)

        val masterListViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(MasterListViewModel::class.java)

        val adapter = MasterListEntityAdapter()
        binding.tasksList.adapter = adapter

        masterListViewModel.allTasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.addTaskButton.setOnClickListener() {onPressingDone()}

        binding.clearButton.setOnClickListener() {onPressingClear()}

        binding.setLifecycleOwner(this)

        binding.masterListViewModel = masterListViewModel

        return binding.root
    }
    fun onPressingDone() {
        val task: String = binding.taskName.text.toString()
        binding.taskName.getText().clear();
        binding.masterListViewModel?.addTask(task)
    }
    fun onPressingClear() {
        binding.masterListViewModel?.clearTasks()
    }
}
