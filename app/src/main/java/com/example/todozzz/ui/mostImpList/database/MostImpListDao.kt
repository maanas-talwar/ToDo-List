package com.example.todozzz.ui.mostImpList.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todozzz.ui.mostImpList.database.MostImpListEntity

@Dao
interface MostImpListDao {
    @Insert
    fun insert(task: MostImpListEntity)

//    @Update
//    fun update(task: MostImpListEntity)
//
//    @Delete
//    fun delete(task: MostImpListEntity)

    @Query("SELECT * FROM mostImp_list_entity ORDER BY taskId ASC")
    fun getAllTasks(): LiveData<List<MostImpListEntity>>

    @Query("DELETE FROM mostImp_list_entity")
    fun clear()
}