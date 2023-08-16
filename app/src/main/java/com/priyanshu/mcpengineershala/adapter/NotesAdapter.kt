package com.priyanshu.mcpengineershala.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickNotes
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.NotesItemBinding
import com.priyanshu.mcpengineershala.dataclasses.Notes


class NotesAdapter(var context: StudentMainScreenActivity, var notesList:ArrayList<Notes>, var onUserClickNotes: OnUserClickNotes):RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    class ViewHolder(var binding: NotesItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = NotesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvSubject.text=notesList[position].subject
        holder.binding.tvTitle.text=notesList[position].title
        holder.binding.tvDate.text=notesList[position].date
        holder.binding.tvDept.text=notesList[position].time


        holder.itemView.setOnClickListener{
            onUserClickNotes.onUserNotes(notesList[position])
        }
    }

    override fun getItemCount(): Int {
      return notesList.size
    }
}