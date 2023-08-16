package com.priyanshu.mcpengineershala.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClick
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickAnnouncement
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.AnnouncementItemBinding
import com.priyanshu.mcpengineershala.databinding.StudentItemBinding
import com.priyanshu.mcpengineershala.dataclasses.Announcement
import com.priyanshu.mcpengineershala.dataclasses.Teachers


class AnnouncementAdapter(var context: StudentMainScreenActivity, var announcementList:ArrayList<Announcement>, var onUserClickAnnouncement: OnUserClickAnnouncement):RecyclerView.Adapter<AnnouncementAdapter.ViewHolder>() {
    class ViewHolder(var binding: AnnouncementItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AnnouncementItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text=announcementList[position].title
        holder.binding.tvDate.text=announcementList[position].date
        holder.binding.tvTime.text=announcementList[position].time



        println(announcementList[position].description)
        holder.itemView.setOnClickListener{
            onUserClickAnnouncement.onUserAnnouncement(announcementList[position])
        }
    }

    override fun getItemCount(): Int {
      return announcementList.size
    }
}