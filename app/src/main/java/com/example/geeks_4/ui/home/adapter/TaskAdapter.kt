package com.example.geeks_4.ui.home.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.geeks_4.databinding.IteamTaskBinding
import com.example.geeks_4.model.Task


class TaskAdapter(val onClickOne: (Task) -> Unit) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var second = 0
    private val list = arrayListOf<Task>()

//    @SuppressLint("NotifyDataSetChanged")
//    fun setData(data: Task) {
//        list.add(0, data)
//        notifyDataSetChanged()
//    }
    fun addData(newList: List<Task>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            IteamTaskBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TaskViewHolder(private val binding: IteamTaskBinding) : ViewHolder(binding.root) {
        private fun сallingСounter(): Int {
            second++
            return second
        }

        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc

            if (сallingСounter() % 2 == 0) {
                with(binding) {
                    ItemTask.setBackgroundColor(Color.BLACK)
                    tvTitle.setTextColor(Color.WHITE)
                    tvDesc.setTextColor(Color.WHITE)
                }
            } else {
                with(binding) {
                    ItemTask.setBackgroundColor(Color.WHITE)
                    tvTitle.setTextColor(Color.BLACK)
                    tvDesc.setTextColor(Color.BLACK)
                }
            }

            itemView.setOnLongClickListener {
                onClickOne(task)
                false
            }

        }
    }

}