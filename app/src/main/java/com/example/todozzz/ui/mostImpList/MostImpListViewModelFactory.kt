package com.example.todozzz.ui.mostImpList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todozzz.ui.mostImpList.MostImpListViewModel
import com.example.todozzz.ui.mostImpList.database.MostImpListDao

class MostImpListViewModelFactory(
    private val dataSource: MostImpListDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MostImpListViewModel::class.java)) {
            return MostImpListViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}