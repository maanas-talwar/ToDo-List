package com.example.todozzz.ui.mostImpList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MostImpListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Most Important Tasks Fragment"
    }
    val text: LiveData<String> = _text
}