package com.example.todozzz.ui.masterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todozzz.R

class MasterListFragment : Fragment() {

    private lateinit var masterListViewModel: MasterListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        masterListViewModel =
                ViewModelProviders.of(this).get(MasterListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_master_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_master_list)
        masterListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
