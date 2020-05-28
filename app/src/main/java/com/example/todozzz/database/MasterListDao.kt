package com.example.todozzz.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MasterListDao {
    @Insert
    fun insert(task: MasterListEntity)

    @Update
    fun update(task: MasterListEntity)

    @Delete
    fun delete(task: MasterListEntity)

    @Query("SELECT * FROM master_list_entity ORDER BY taskId DESC")
    fun getAllTasks(): LiveData<List<MasterListEntity>>

//    @Query("SELECT * from master_list_entity WHERE taskId = :key")
//    fun get(key: Long): MasterListEntity?
//
//    @Query("SELECT * FROM master_list_entity ORDER BY taskId DESC LIMIT 1")
//    fun getLatestTask(): MasterListEntity?

}