package com.example.todozzz.ui.masterList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todozzz.R
import com.example.todozzz.TaskItemViewHolder
import com.example.todozzz.database.MasterListEntity

class MasterListEntityAdapter: RecyclerView.Adapter<MasterListEntityAdapter.ViewHolder> () {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val taskData: TextView = itemView.findViewById(R.id.task_data)
        val deleteTaskIcon: ImageView = itemView.findViewById(R.id.done_task_icon)
    }

    var data =  listOf<MasterListEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.taskData.text = item.taskInfo
        holder.deleteTaskIcon.setImageResource(R.drawable.clear_task_icon)
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