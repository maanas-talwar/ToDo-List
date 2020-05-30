package com.example.todozzz.ui.masterList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todozzz.R
import com.example.todozzz.database.MasterListEntity

class MasterListEntityAdapter : ListAdapter<MasterListEntity, MasterListEntityAdapter.ViewHolder>(TaskDiffCallback()) {
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

class TaskDiffCallback : DiffUtil.ItemCallback<MasterListEntity>() {
    override fun areItemsTheSame(oldItem: MasterListEntity, newItem: MasterListEntity): Boolean {
        return oldItem.taskId == newItem.taskId
    }

    override fun areContentsTheSame(oldItem: MasterListEntity, newItem: MasterListEntity): Boolean {
        return oldItem == newItem
    }

}