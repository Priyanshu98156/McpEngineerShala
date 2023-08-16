package com.priyanshu.mcpengineershala.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClick
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickAnnouncement
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickAssignment
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.AnnouncementItemBinding
import com.priyanshu.mcpengineershala.databinding.AssignmentItemBinding
import com.priyanshu.mcpengineershala.databinding.StudentItemBinding
import com.priyanshu.mcpengineershala.dataclasses.Announcement
import com.priyanshu.mcpengineershala.dataclasses.Assignment
import com.priyanshu.mcpengineershala.dataclasses.Teachers


class AssignmentAdapter(var context: StudentMainScreenActivity, var assignmentList:ArrayList<Assignment>, var onUserClickAssignment: OnUserClickAssignment):RecyclerView.Adapter<AssignmentAdapter.ViewHolder>() {
    class ViewHolder(var binding: AssignmentItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AssignmentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvSubject.text=assignmentList[position].subject
        holder.binding.tvTitle.text=assignmentList[position].title
        holder.binding.givenDate.text=assignmentList[position].givenDate
        holder.binding.submissionDate.text=assignmentList[position].submissionDate

        holder.itemView.setOnClickListener{
            onUserClickAssignment.onUserAssignment(assignmentList[position])
        }
    }

    override fun getItemCount(): Int {
      return assignmentList.size
    }
}