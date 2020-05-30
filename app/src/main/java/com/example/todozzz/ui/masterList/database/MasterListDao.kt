package com.example.todozzz.ui.masterList.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MasterListDao {
    @Insert
    fun insert(task: MasterListEntity)

//    @Update
//    fun update(task: MasterListEntity)
//
//    @Delete
//    fun delete(task: MasterListEntity)

    @Query("SELECT * FROM master_list_entity ORDER BY taskId ASC")
    fun getAllTasks(): LiveData<List<MasterListEntity>>

    @Query("DELETE FROM master_list_entity")
    fun clear()
}