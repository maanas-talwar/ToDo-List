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

class MostImpListFragment : Fragment() {

    private lateinit var binding: FragmentMostImpListBinding

    private lateinit var mostImpListViewModel: MostImpListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mostImpListViewModel =
                ViewModelProviders.of(this).get(MostImpListViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_most_imp_list, container, false)
        mostImpListViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textMostImpList.text = it
        })
        return binding.root
    }
}
