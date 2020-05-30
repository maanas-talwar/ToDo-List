package com.example.todozzz.ui.weeklyList.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weekly_list_entity")
data class WeeklyListEntity(
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    @ColumnInfo(name = "task_info")
    var taskInfo: String = "",

    @ColumnInfo(name = "is_completed")
    var isCompleted: Boolean = false
)