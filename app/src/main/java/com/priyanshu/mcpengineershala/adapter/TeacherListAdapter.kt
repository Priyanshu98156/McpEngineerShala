package com.priyanshu.mcpengineershala.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClick
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.StudentItemBinding
import com.priyanshu.mcpengineershala.dataclasses.Teachers


class TeacherListAdapter(var context: StudentMainScreenActivity, var teacherList:ArrayList<Teachers>, var onUserClick: OnUserClick):RecyclerView.Adapter<TeacherListAdapter.ViewHolder>() {
    class ViewHolder(var binding: StudentItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = StudentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.course.text=teacherList[position].teacher_name
        holder.binding.name.text=teacherList[position].teacher_dept
        holder.binding.phone.text=teacherList[position].teacher_Email
        holder.itemView.setOnClickListener{
            onUserClick.onUser(teacherList[position])
        }
    }

    override fun getItemCount(): Int {
      return teacherList.size
    }
}