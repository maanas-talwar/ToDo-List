package com.example.todozzz.ui.weeklyList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todozzz.R
import com.example.todozzz.ui.weeklyList.database.WeeklyListEntity

class WeeklyListEntityAdapter : ListAdapter<WeeklyListEntity, WeeklyListEntityAdapter.ViewHolder>(TaskDiffCallback()) {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val taskData: TextView = itemView.findViewById(R.id.task_checkBox)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.taskData.text = item.taskInfo
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_item_task,
                parent, false)
        return ViewHolder(view)
    }
}

class TaskDiffCallback : DiffUtil.ItemCallback<WeeklyListEntity>() {
    override fun areItemsTheSame(oldItem: WeeklyListEntity, newItem: WeeklyListEntity): Boolean {
        return oldItem.taskId == newItem.taskId
    }

    override fun areContentsTheSame(oldItem: WeeklyListEntity, newItem: WeeklyListEntity): Boolean {
        return oldItem == newItem
    }

}