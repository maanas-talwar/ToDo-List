package com.example.todozzz.ui.masterList.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "master_list_entity")
data class MasterListEntity(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    @ColumnInfo(name = "task_info")
    var taskInfo: String = "",

    @ColumnInfo(name = "is_completed")
    var isCompleted: Boolean = false
)