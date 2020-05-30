package com.example.todozzz.ui.weeklyList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todozzz.ui.weeklyList.database.WeeklyListDao

class WeeklyListViewModelFactory(
    private val dataSource: WeeklyListDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeeklyListViewModel::class.java)) {
            return WeeklyListViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}