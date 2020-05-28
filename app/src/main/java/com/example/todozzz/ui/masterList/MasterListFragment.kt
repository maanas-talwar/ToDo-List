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
import com.example.todozzz.database.TasksDatabase
import com.example.todozzz.databinding.FragmentMasterListBinding

class MasterListFragment : Fragment() {

    private lateinit var binding: FragmentMasterListBinding

//    private lateinit var masterListViewModel: MasterListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        masterListViewModel =
//                ViewModelProviders.of(this).get(MasterListViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_master_list, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = TasksDatabase.getInstance(application).masterListDao

        val viewModelFactory = MasterListViewModelFactory(dataSource, application)

        val masterListViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(MasterListViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.masterListViewModel = masterListViewModel

        return binding.root
    }
}
