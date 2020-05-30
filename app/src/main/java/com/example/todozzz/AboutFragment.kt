package com.example.todozzz

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todozzz.R
import com.example.todozzz.databinding.FragmentAboutBinding
import com.example.todozzz.databinding.FragmentMostImpListBinding
import com.example.todozzz.ui.mostImpList.MostImpListViewModel

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
        val text: String = "A ToDo list manager to boost your productivity.<br>The tasks are divided into 3 categories:" +
                "    <ul><li><b>Most Important Tasks</b> - tasks requiring immediate attention</li> <li><b>Weekly List</b> - goals for the next 7 days</li> <li><b>Master List</b> - long term goals</li></ul><br>" +
                "<b>Usage:</b> <ul><li>You can save the tasks by enter the task name and clicking 'Add Task' button.</li> <li>You can clear the created tasks by clicking 'Clear' button.</li>" +
                "    Enjoy this ToDo list manager and achieve your goals :) <br><br> Created by: <b>MAANAS TALWAR</b>"
        binding.aboutText.text = Html.fromHtml(text)
        (activity as MainActivity).supportActionBar?.title = getString(R.string.about)
        return binding.root
    }

}
