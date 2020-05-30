package com.example.todozzz.ui.mostImpList.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mostImp_list_entity")
data class MostImpListEntity(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    @ColumnInfo(name = "task_info")
    var taskInfo: String = "",

    @ColumnInfo(name = "is_completed")
    var isCompleted: Boolean = false
)