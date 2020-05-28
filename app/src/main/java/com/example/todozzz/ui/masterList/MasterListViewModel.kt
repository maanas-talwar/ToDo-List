package com.example.todozzz.ui.masterList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todozzz.database.MasterListDao

class MasterListViewModel(
    val database: MasterListDao,
    application: Application) : AndroidViewModel(application) {
}


//*****prev state*****
//class MasterListViewModel : ViewModel() {
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is Master List Fragment"
//    }
//    val text: LiveData<String> = _text
//}