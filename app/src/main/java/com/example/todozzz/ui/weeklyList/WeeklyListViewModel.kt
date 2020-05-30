package com.example.todozzz.ui.weeklyList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todozzz.ui.weeklyList.database.WeeklyListDao
import com.example.todozzz.ui.weeklyList.database.WeeklyListEntity
import kotlinx.coroutines.*

class WeeklyListViewModel(
    val database: WeeklyListDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val allTasks = database.getAllTasks()

    fun addTask(task: String) {
        uiScope.launch {
            val newTask = WeeklyListEntity(taskInfo = task)
            insert(newTask)
        }
    }
    private suspend fun insert(task: WeeklyListEntity) {
        withContext(Dispatchers.IO) {
            database.insert(task)
        }
    }
    fun clearTasks() {
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}