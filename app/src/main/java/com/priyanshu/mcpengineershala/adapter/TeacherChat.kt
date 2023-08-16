package com.priyanshu.mcpengineershala.adapter

import android.view.LayoutInflater
import android.view.View
import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.abhijeet.todolist.dataclases.Message
import com.google.firebase.auth.FirebaseAuth
import com.priyanshu.mcpengineershala.Interface.OnTeacherClicked
import com.priyanshu.mcpengineershala.R

class TeacherChat(var context: Context, var messagesList: ArrayList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
 var  ITEM_RECEIVE = 1
    var ITEM_SENT = 2




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        if (viewType==1){
            var  view: View = LayoutInflater.from(context).inflate(R.layout.recieving_message,parent,false)
            return ReceiveViewHolder(view)
        }
        else{
            var  view: View = LayoutInflater.from(context).inflate(R.layout.sent_message,parent,false)
            return SentViewHolder(view)

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var currentmsg = messagesList[position]
        if (holder.javaClass==SentViewHolder::class.java){
            var holder= holder as SentViewHolder
            holder.sentmessage.text= currentmsg.message

        }
        else{
            var holder = holder as ReceiveViewHolder
            holder.receiveMessage.text=currentmsg.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        var currentmessage = messagesList[position]

        if (FirebaseAuth.getInstance().currentUser?.uid.equals(currentmessage.senderId)) {
            return ITEM_SENT
        } else {
            return ITEM_RECEIVE
        }

    }
    override fun getItemCount(): Int {
        return messagesList.size

    }
    class SentViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        var sentmessage = itemView.findViewById<TextView>(R.id.sendmsg)
    }
    class ReceiveViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        var receiveMessage = itemView.findViewById<TextView>(R.id.receive)
    }

}