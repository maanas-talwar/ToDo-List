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

    @Query("SELECT * FROM master_list_entity")
    fun getAllNights(): LiveData<List<MasterListEntity>>
}