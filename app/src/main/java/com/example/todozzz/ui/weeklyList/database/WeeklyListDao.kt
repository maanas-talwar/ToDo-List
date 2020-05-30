package com.example.todozzz.ui.weeklyList.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todozzz.ui.weeklyList.database.WeeklyListEntity

@Dao
interface WeeklyListDao {
    @Insert
    fun insert(task: WeeklyListEntity)

//    @Update
//    fun update(task: WeeklyListEntity)
//
//    @Delete
//    fun delete(task: WeeklyListEntity)

    @Query("SELECT * FROM weekly_list_entity ORDER BY taskId ASC")
    fun getAllTasks(): LiveData<List<WeeklyListEntity>>

    @Query("DELETE FROM weekly_list_entity")
    fun clear()
}