package com.example.todozzz.ui.mostImpList.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todozzz.ui.mostImpList.database.MostImpListDao

@Database(entities = [MostImpListEntity::class], version = 3, exportSchema = false)
abstract class TasksDatabase: RoomDatabase() {

    abstract val mostImpListDao: MostImpListDao

    companion object {
        @Volatile
        private var INSTANCE: TasksDatabase? = null

        fun getInstance(context: Context): TasksDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TasksDatabase::class.java,
                        "all_tasks_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}