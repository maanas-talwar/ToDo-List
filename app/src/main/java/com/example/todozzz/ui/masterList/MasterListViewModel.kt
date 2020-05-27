package com.example.todozzz.ui.masterList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todozzz.database.MasterListDao

class MasterListViewModel(
    val database: MasterListDao,
    application: Application) : AndroidViewModel(application) {
}