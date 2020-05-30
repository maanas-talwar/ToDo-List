package com.example.todozzz.ui.mostImpList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todozzz.ui.mostImpList.database.MostImpListDao
import com.example.todozzz.ui.mostImpList.database.MostImpListEntity
import kotlinx.coroutines.*

class MostImpListViewModel(
    val database: MostImpListDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val allTasks = database.getAllTasks()

    fun addTask(task: String) {
        uiScope.launch {
            val newTask = MostImpListEntity(taskInfo = task)
            insert(newTask)
        }
    }
    private suspend fun insert(task: MostImpListEntity) {
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