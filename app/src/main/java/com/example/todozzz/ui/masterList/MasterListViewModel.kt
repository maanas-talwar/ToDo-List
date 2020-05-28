package com.example.todozzz.ui.masterList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todozzz.database.MasterListDao
import com.example.todozzz.database.MasterListEntity
import com.example.todozzz.databinding.FragmentMasterListBinding
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

    val AllTasks = database.getAllTasks()

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

    fun addTask(task_name: String) {
        uiScope.launch {
            val newTask = MasterListEntity()
            newTask.taskInfo = task_name
            insert(newTask)
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