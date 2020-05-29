package com.example.todozzz.ui.masterList

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.todozzz.database.MasterListDao
import com.example.todozzz.database.MasterListEntity
import com.example.todozzz.formatTasks
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MasterListViewModel(
    val database: MasterListDao,
    application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val allTasks = database.getAllTasks()

    val taskString = Transformations.map(allTasks) { allTasks ->
        formatTasks(allTasks, application.resources)
    }
//    private var LatestTask = MutableLiveData<MasterListEntity?>()
//    init {
//        initializeTask()
//    }
//    private fun initializeTask() {
//        uiScope.launch {
//            LatestTask.value = getLatestTaskFromDatabase()
//        }
//    }
//    private suspend fun getLatestTaskFromDatabase(): MasterListEntity? {
//        return withContext(Dispatchers.IO) {
//            var task = database.getLatestTask()
//            if (task?.taskInfo != "") {
//                task = null
//            }
//            task
//        }
//    }

    fun addTask(task: String) {
        uiScope.launch {
            Log.v("TAG", "Inside addTask")
            var newTask = MasterListEntity(taskInfo = task)
//            newTask.taskInfo = task_name
            insert(newTask)
        }
    }

    fun clearTasks() {
        uiScope.launch {
            clear()
        }
    }

    suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
    private suspend fun insert(task: MasterListEntity) {
        withContext(Dispatchers.IO) {
            database.insert(task)
        }
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}