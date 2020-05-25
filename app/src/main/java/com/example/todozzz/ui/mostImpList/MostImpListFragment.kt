package com.example.todozzz.ui.mostImpList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todozzz.R

class MostImpListFragment : Fragment() {

    private lateinit var mostImpListViewModel: MostImpListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mostImpListViewModel =
                ViewModelProviders.of(this).get(MostImpListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_most_imp_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_most_imp_list)
        mostImpListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
