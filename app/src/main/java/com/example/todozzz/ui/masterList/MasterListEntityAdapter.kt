package com.example.todozzz.ui.masterList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todozzz.R
import com.example.todozzz.TaskItemViewHolder
import com.example.todozzz.database.MasterListEntity

class MasterListEntityAdapter: RecyclerView.Adapter<TaskItemViewHolder> () {
    var data =  listOf<MasterListEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.taskInfo

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.task_item_view, parent, false) as TextView
        return TaskItemViewHolder(view)
    }
}