package com.example.todozzz.ui.masterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MasterListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Master List Fragment"
    }
    val text: LiveData<String> = _text
}