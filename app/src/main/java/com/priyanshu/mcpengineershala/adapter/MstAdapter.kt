package com.priyanshu.mcpengineershala.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickMst
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.MstItemBinding
import com.priyanshu.mcpengineershala.dataclasses.MstRecord


class MstAdapter(var context: StudentMainScreenActivity, var mstList:ArrayList<MstRecord>, var onUserClickMst: OnUserClickMst):RecyclerView.Adapter<MstAdapter.ViewHolder>() {
    class ViewHolder(var binding: MstItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = MstItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvSubject.text=mstList[position].subject
        holder.binding.tvTitle.text=mstList[position].title
        holder.binding.tvDate.text=mstList[position].date
        holder.binding.tvDept.text=mstList[position].dept


        holder.itemView.setOnClickListener{
            onUserClickMst.onUserMst(mstList[position])
        }
    }

    override fun getItemCount(): Int {
      return mstList.size
    }
}